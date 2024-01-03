import { gameRepository } from "../om/game.js";

async function get(req, res) {
    const id = req.params.id;
    const game = await gameRepository.fetch(id);

    if (game) {
        res.status = 200;
        res.json(game);
    } else {
        res.status = 404;
        res.send("Not found");
    }
}

async function post(req, res) {
    const id = req.body.id.toString();
    const game = await gameRepository.save(id, req.body);

    res.statusCode = 200;
    res.type('application/json');
    res.send(game);
}

async function update(req, res) {
    const id = req.params.id;
    let game = await gameRepository.fetch(id);

    if (game) {
        game = await gameRepository.save(id, req.body);
        res.status = 200;
        res.json(game);
    } else {
        res.status = 404;
        res.send("Not found");
    }
}

async function remove(req, res) {
    const id = req.params.id;
    await gameRepository.remove(id);

    res.type('application/json');
    res.send('"OK"');
}

export default {
    post,
    get,
    update,
    remove
}