import {Game} from "./game";
import {Store} from "./store";

export interface GameStore {
  id: number,
  game: Game,
  store: Store,
  url: string
}
