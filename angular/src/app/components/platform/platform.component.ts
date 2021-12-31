import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import {Observable, of, tap} from "rxjs";
import {Game} from "../../../types/game";
import {GameService} from "../../services/game.service";
import {ActivatedRoute} from "@angular/router";
import {Platform} from "../../../types/platform";

@Component({
  selector: 'app-platform',
  templateUrl: './platform.component.html',
  styleUrls: ['./platform.component.scss'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class PlatformComponent implements OnInit {
  platform$: Observable<Platform> | undefined;
  game$: Observable<Game[]> | undefined;
  page: number = 1;
  games: Game[] = [];

  // @ts-ignore
  constructor(private readonly gameService: GameService,
              private route: ActivatedRoute) {
    const id = this.route.snapshot.paramMap.get('id');

    if (id !== null) {
      this.game$ = gameService.findAllByPlatform(+id, this.page)
        .pipe(
          tap(games => {
            for (let i = 0; i < games[0].platforms.length; i++) {
              if(games[0].platforms[i].id === +id) {
                this.platform$ = of(games[0].platforms[i]);
                break;
              }
              this.games = games;
            }
          })
        );
    } else {
      console.error("Can't find the tag")
    }
  }

  ngOnInit(): void {
  }

  loadMore(): void {
    this.page++;

    const id = this.route.snapshot.paramMap.get('id');

    // @ts-ignore
    this.gameService.findAllByPlatform(+id, this.page)
      .forEach((games) => {
        for (let i = 0; i < games.length; i++){
          this.games.push(games[i]);
        }
      });
  }
}
