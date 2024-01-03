import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {catchError, Observable, of, switchMap} from "rxjs";
import {Game} from "../../types/game";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  private readonly searchUrl = '/games';
  private readonly gameUrl = '/rest/games';
//  private readonly cacheUrl = '8002/games'; // todo use proxy
  private readonly cacheUrl = 'http://localhost:8002/games';

  constructor(private readonly http: HttpClient) { }

  find(id: number): Observable<Game> {
    return this.http.get<Game>(`${this.cacheUrl}/${id}`)
      .pipe(
        catchError(error => {
          console.error(error);
          const id = -1;
          return of({id} as Game);
        }),
        switchMap(result => {
          // NOTE: for some reason a failed result gives ud {} (an empty object)
          // So we just check the amount of fields to see if it was a success
          const gameFound = Object.keys(result).length == 0;
          if (gameFound) {
            return this.http.get<Game>(`${this.gameUrl}/${id}`)
              .pipe(
                catchError(anotherError => {
                  console.error(anotherError);
                  return of({ id } as Game);
                })
              );
          } else {
            return of(result);
          }
        })
      );
  }

  findAllByName(name: string, page: number): Observable<Game[]> {
    name = name.trim();
    const options = name ? { params: new HttpParams().set('name', name).set('page', page) } : {};

    if (name != '') {
      return this.http.get<Game[]>(`${this.searchUrl}`, options)
        .pipe(
          catchError(error => {
            // if search service didn't find it, try other service
            if (error.status == 404) {
              return this.http.get<Game[]>(`${this.gameUrl}` + `/search=${name}&page=${page+1}`)
              .pipe(
                catchError(anotherError => {
                  console.error(anotherError);
                  return of([]);
                })
              );
            } else {
              console.error(error.status);
              return of([]);
            }
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
