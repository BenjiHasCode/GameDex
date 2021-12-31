import {Game} from "./game";

export interface Developer {
  id: number,
  name: string,
  description: string,
  games: Game[]
}
