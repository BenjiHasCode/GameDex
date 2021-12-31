import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import {Observable, of, tap} from "rxjs";
import {Game} from "../../../types/game";
import {GameService} from "../../services/game.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Developer} from "../../../types/developer";

@Component({
  selector: 'app-developer',
  templateUrl: './developer.component.html',
  styleUrls: ['./developer.component.scss'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class DeveloperComponent implements OnInit {
  game$: Observable<Game[]> | undefined;
  developer$: Observable<Developer> | undefined;
  page: number = 1;
  games: Game[] = [];

  // @ts-ignore
  constructor(private readonly gameService: GameService,
              private route: ActivatedRoute,
              private router: Router) {
    const id = this.route.snapshot.paramMap.get('id');

    if (id !== null) {
      this.game$ = this.gameService.findAllByDeveloper(+id, this.page)
        .pipe(
          tap((games) => {
            this.games = games;
          })
        );
    } else {
      console.error("Can't find the tag")
    }

    // @ts-ignore
    this.developer$ = of(this.router.getCurrentNavigation().extras.state.developer);
  }

  ngOnInit(): void {
  }

  loadMore(): void {
    this.page++;

    const id = this.route.snapshot.paramMap.get('id');

    // @ts-ignore
    this.gameService.findAllByDeveloper(+id, this.page)
      .forEach((games) => {
        for (let i = 0; i < games.length; i++){
          this.games.push(games[i]);
        }
      });
  }
}
