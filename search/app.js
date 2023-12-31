import express from 'express';
import dotenv from 'dotenv';
dotenv.config({ path: './.env' });
import gameRouter from './routes/GameRouter.js';

const app = express();
app.use(express.json());
app.use(gameRouter);

const PORT = process.env.port || 3000;
app.listen(PORT, () => {
    console.log(`Server is running on port: ${PORT}`);
});
