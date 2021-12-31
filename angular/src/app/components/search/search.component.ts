import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import {GameService} from "../../services/game.service";
import {FormControl} from "@angular/forms";
import {debounceTime, distinctUntilChanged, Observable, switchMap, tap} from "rxjs";
import {Game} from "../../../types/game";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class SearchComponent implements OnInit {
  searchControl = new FormControl();
  searchResult: Observable<Game[]>;
  page: number = 1;
  games: Game[] = [];

  // @ts-ignore
  constructor(private readonly gameService: GameService) {
    const search = (this.searchControl.valueChanges as Observable<string>);
    this.searchResult = search.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap(value =>
        gameService.findAllByName(value, this.page).pipe(
          tap((games) => {
            this.games = [];
            for (let i = 0; i < games.length; i++){
              this.games.push(games[i]);
            }

            // @ts-ignore
            document.getElementById('seeMore').hidden = value === "";
          })
      ))
    );
  }

  ngOnInit(): void {
  }

  loadMore(): void {
    this.page++;

    const value = this.searchControl.value;
    const size = this.games.length;

    this.gameService.findAllByName(value, this.page)
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
