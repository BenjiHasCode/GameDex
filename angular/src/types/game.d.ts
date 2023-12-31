import {Publisher} from "./publisher";
import {Developer} from "./developer";
import {Tag} from "./tag";
import {Genre} from "./genre";
import {Platform} from "./platform";
import {Screenshot} from "./screenshot";
import {GameStore} from "./gamestore";

export interface Game {
  id: number,
  name: string,
  description: string,
  metacritic: number,
  //background_image: string,
  image: string,
  released: string,
  playtime: number,

  screenshots: Screenshot[] | null,
  publishers: Publisher[],
  developers: Developer[],
  tags: Tag[],
  genres: Genre[],
  stores: GameStore[],
  platforms: Platform[];
}
