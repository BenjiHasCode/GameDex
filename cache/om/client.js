import { createClient } from 'redis';

const url = process.env.REDIS_URL;
const client = createClient({ url: url });
await client.connect();

export default client;