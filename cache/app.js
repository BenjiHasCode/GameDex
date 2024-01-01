import 'dotenv/config';
import express from 'express';
import swaggerUi from 'swagger-ui-express';
import YAML from 'yamljs';
import cors from 'cors';
import gameRouter from './routes/GameRouter.js';

/* set up express */
const app = express();
app.use(express.json());
app.use(cors());
app.use(gameRouter);

/* set up swagger */
const swaggerDocument = YAML.load('api.yaml');
app.use('/', swaggerUi.serve, swaggerUi.setup(swaggerDocument));

/* start server */
const PORT = process.env.port || 8002;
app.listen(PORT, () => {
    console.log(`Server is running on port: ${PORT}`);
});
