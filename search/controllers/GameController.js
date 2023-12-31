import { MeiliSearch } from 'meilisearch';

const client = new MeiliSearch({
    host: 'http://localhost:7700', // TODO DOCKER URL
    limit: 5
  });


async function get(req, res) {
    const limit = 24;
    const offset = limit * req.query.page;
    const searchResult = await client.index('games')
        .search(req.query.name, {limit: 24, offset:offset});

    if (searchResult.hits.length > 0) {
        res.statusCode = 200;
        res.send(searchResult.hits);
    } else {
        res.statusCode = 404;
        res.send('Not found');
    }
}

async function post(req, res) {
    const result = await client.index('games').addDocuments(req.body);
    
    res.statusCode = 102;
    res.send({ message: "processing batch", taskUid: result.taskUid });
}

/*async function postCollection(req, res) {
    const result = await client.index('games').addDocumentsInBatches(req.body);
    
    res.statusCode = 102;
    res.send({ message: "processing batch", taskUid: result.taskUid });
}*/

export default {
    get,
    post,
//    postCollection
}