import {Game} from "./game";

export interface Publisher {
  id: number,
  name: string,
  description: string,
  games: Game[]
}
