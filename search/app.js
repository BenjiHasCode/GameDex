import MeiliSearch from 'meilisearch';
import express from 'express';
import dotenv from 'dotenv';
dotenv.config({ path: './.env' });

const app = express();

app.get("/", (req, res) => {
    res.send("Hello, World!");
});

const PORT = process.env.port || 3000;
app.listen(PORT, () => {
    console.log(`Server is running on port: ${PORT}`);
});