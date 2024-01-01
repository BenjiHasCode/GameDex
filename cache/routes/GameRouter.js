import express from "express";
import GameController from "./../controllers/GameController.js";
import GameFormat from "../middleware/GameFormat.js";

const router = express.Router();

// GET
router.route("/games/:id").get(GameController.get);

// POST
router.route("/games").post(GameFormat.format, GameController.post);

export default router;