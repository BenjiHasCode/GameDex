// format the req.body into a format that we desire
function format(req, res, next) {
    req.body = formatGame(req.body);
    next();
}

// format the req.body into a collection of games in the format that we desire
function formatCollection(req, res, next) {
    const games = [];
    req.body.forEach((game) => {
        games.push(formatGame(game));
    });
    req.body = games;
    next();
}


function formatGame(game) {
    const publishers = [];
    if (game.publishers) {
        game.publishers.forEach((publisher) => {
            publishers.push(publisher.name);
        });
    }

    const developers = [];
    if (game.developers) {
        game.developers.forEach((developer) => {
            developers.push(developer.name);
        });
    }

    const tags = [];
    if (game.tags) {
        game.tags.forEach((tag) => {
            tags.push(tag.name);
        });
    }

    const genres = [];
    if (game.genres) {
        game.genres.forEach((genre) => {
            genres.push(genre.name);
        });
    }

    const stores = [];
    if (game.stores) {
        game.stores.forEach((store) => {
            stores.push(store.name);
        });
    }

    const platforms = [];
    if (game.platforms) {
        game.platforms.forEach((platform) => {
            platforms.push(platform.name);
        });
    }
   
    return {
        id: game.id,
        name: game.name,
        description: game.description,
        image: game.background_image,
        publishers: publishers,
        developers: developers,
        tags: tags,
        genres: genres,
        stores: stores,
        platforms: platforms
    }
}

export default {
    format,
    formatCollection
}