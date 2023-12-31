import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {Game} from "../../types/game";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  private readonly gameUrl = '/games';

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
    name = name.trim();

    page = 0;
    const options = name ? { params: new HttpParams().set('name', name).set('page', page) } : {};

    if (name != '') {
      return this.http.get<Game[]>(`${this.gameUrl}`, options)
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
