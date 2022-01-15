import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {Game} from "../../types/game";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  private readonly gameUrl = '/rest/games';

  constructor(private readonly http: HttpClient) { }

  find(id: number): Observable<Game> {
    return this.http.get<Game>(`${this.gameUrl}/${id}`)
      .pipe(
        catchError(error => {
          console.error(error);
          const id = -1;
          return of({id} as Game);
        })
      );
  }

  findAllByName(name: string, page: number): Observable<Game[]> {
    if (name != '') {
      return this.http.get<Game[]>(`${this.gameUrl}/search=${name}&page=${page}`)
        .pipe(
          catchError(error => {
            console.error(error);
            return of([]);
          })
        );
    }
    else {
      return of([]);
    }
  }

  findAllByTag(id: number, page: number): Observable<Game[]> {
    return this.http.get<Game[]>(`${this.gameUrl}/tag=${id}&page=${page}`)
      .pipe(
        catchError(error => {
          console.error(error);
          return of([]);
        })
      );
  }

  findAllByGenre(id: number, page: number): Observable<Game[]> {
    return this.http.get<Game[]>(`${this.gameUrl}/genre=${id}&page=${page}`)
      .pipe(
        catchError(error => {
          console.error(error);
          return of([]);
        })
      );
  }

  findAllByDeveloper(id: number, page: number): Observable<Game[]> {
    return this.http.get<Game[]>(`${this.gameUrl}/developer=${id}&page=${page}`)
      .pipe(
        catchError(error => {
          console.error(error);
          return of([]);
        })
      );
  }

  findAllByPlatform(id: number, page: number): Observable<Game[]> {
    return this.http.get<Game[]>(`${this.gameUrl}/platform=${id}&page=${page}`)
      .pipe(
        catchError(error => {
          console.error(error);
          return of([]);
        })
      );
  }
}
