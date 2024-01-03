import express from "express";
import GameController from "./../controllers/GameController.js";

const router = express.Router();

router.route("/games/:id").get(GameController.get);
router.route("/games").post(GameController.post);
router.route("/games").put(GameController.update);
router.route("/games").delete(GameController.remove);

export default router;