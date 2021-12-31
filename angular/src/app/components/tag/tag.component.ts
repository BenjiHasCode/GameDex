import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import {GameService} from "../../services/game.service";
import {ActivatedRoute} from "@angular/router";
import {Observable, of, tap} from "rxjs";
import {Game} from "../../../types/game";
import {Tag} from "../../../types/tag";

@Component({
  selector: 'app-tag',
  templateUrl: './tag.component.html',
  styleUrls: ['./tag.component.scss'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class TagComponent implements OnInit {
  tag$: Observable<Tag> | undefined;
  game$: Observable<Game[]> | undefined;
  page: number = 1;
  games: Game[] = [];


  // @ts-ignore
  constructor(private readonly gameService: GameService,
              private route: ActivatedRoute) {
    const id = this.route.snapshot.paramMap.get('id');

    if (id !== null) {
      this.game$ = gameService.findAllByTag(+id, this.page)
        .pipe(
          tap(games => {
            for (let i = 0; i < games[0].tags.length; i++) {
              if(games[0].tags[i].id === +id) {
                this.tag$ = of(games[0].tags[i]);
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
    const size = this.games.length;

    // @ts-ignore
    this.gameService.findAllByTag(+id, this.page)
      .forEach((games) => {
        for (let i = 0; i < games.length; i++){
          this.games.push(games[i]);
        }

        if(size == this.games.length) {
          // @ts-ignore
          document.getElementById('seeMore').hidden = true;
        }
      });
  }
}
