import express from "express";
import GameController from "./../controllers/GameController.js";
import GameFormat from "../middleware/GameFormat.js";
import QueryValidator from "../middleware/QueryValidator.js";

const router = express.Router();

// GET
router.route("/games").get(QueryValidator.validate, GameController.get);

// POST
router.route("/games").post(GameFormat.format, GameController.post);
router.route("/games/populate").post(GameFormat.formatCollection, GameController.post);

export default router;