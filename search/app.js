import MeiliSearch from 'meilisearch';
import express from 'express';
import dotenv from 'dotenv';
dotenv.config({ path: './.env' });

const app = express();

app.get("/games", (req, res) => {
    if(req.query.name && req.query.page) {
        res.send("yes");
    }
    console.log(req.query);
    res.send("no");
});

const PORT = process.env.port || 3000;
app.listen(PORT, () => {
    console.log(`Server is running on port: ${PORT}`);
});