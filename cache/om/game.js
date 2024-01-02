import { Entity, Schema } from "redis-om";
import client from "./client.js";

/* game entity */
class Game extends Entity {}

/* create a Schema for Game */
const gameSchema = new Schema(Game, {
    id: { type: 'number' },
    name: { type: 'string' },
    description: { type: 'string' },
    metacritic: { type: 'number' },
    background_image: { type: 'string' },
    released: { type: 'date' },
    playtime: { type: 'number' } //huh?! don't remember this one
});