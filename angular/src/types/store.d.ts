import {Game} from "./game";

export interface Store {
  id: number,
  name: string,
  domain: string,
  games_count: number,
  description: string

  games: Game[]
}
