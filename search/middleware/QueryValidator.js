function validate(req, res, next) {
    const searchValid = req.query.name && req.query.name.trim();
    const page = parseInt(req.query.page);

    if (searchValid && page >= 0)
       next();
    else {
        res.statusCode = 400;
        res.send("Query parameters not found. Example '/games?name=GTA6&page=0'");
    }
}

export default {
    validate
}