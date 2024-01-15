import { Schema, Repository } from "redis-om";
import { redis } from "./redis.js";

/* create a Schema for Game */
/*const gameSchema = new Schema(Game, {
    id: { type: 'number' },
    name: { type: 'string' },
    description: { type: 'string' },
    metacritic: { type: 'number' },
    background_image: { type: 'string' },
    released: { type: 'date' },
    playtime: { type: 'number' }
}); */
const schema = new Schema('game', {
    // a bit of a hack, but since embedded data
    // is being worked on, we will have to do with this for now
    // entire games data will be stored in this since we can
    // convert the object into JSON - a string essentially.
    data: { type: 'string' }
});

export const gameRepository = new Repository(schema, redis);

/* create the index for Game */
await gameRepository.createIndex();