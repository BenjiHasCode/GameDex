import express from 'express';
import dotenv from 'dotenv';
dotenv.config({ path: './.env' });
import gameRouter from './routes/GameRouter.js';
import cors from 'cors';

const app = express();
app.use(express.json());
app.use(cors());
app.use(gameRouter);

const PORT = process.env.PORT || 8001;
app.listen(PORT, () => {
    console.log(`Server is running on port: ${PORT}`);
});
