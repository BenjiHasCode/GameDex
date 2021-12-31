import {Game} from "./game";

export interface Platform {
  id: number,
  name: string,
  games: Game[]
}
