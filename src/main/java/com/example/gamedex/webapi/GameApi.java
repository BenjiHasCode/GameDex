package com.example.gamedex.webapi;

import com.example.gamedex.model.Game;
import com.example.gamedex.service.GameService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Set;

@Component
@Path("/games")
public class GameApi {
    private final GameService gameService;

    @Inject
    public GameApi(GameService gameService) {
        this.gameService = gameService;
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        Game game = gameService.find(id);

        Response.Status status = (game != null) ? Response.Status.OK : Response.Status.NOT_FOUND;

        return Response
                .status(status)
                .entity(game)
                .build();
    }

    // TODO migrate this out
    @GET
    @Produces("application/json")
    @Transactional
    @Path("/search={name}&page={page}")
    public Response findAll(@PathParam("name") String name, @PathParam("page") int page) {
        Set<Game> games = gameService.findAll(name, page);
        return Response
                .status(Response.Status.OK)
                .entity(games)
                .build();
    }

    @GET
    @Produces("application/json")
    @Transactional
    @Path("/genre={id}&page={page}")
    public Response findAllByGenre(@PathParam("id") Long id, @PathParam("page") int page) {
        Set<Game> games = gameService.findAllByGenre(id, page);
        // todo check what status to return???
        return Response
                .status(Response.Status.OK)
                .entity(games)
                .build();
    }

    @GET
    @Produces("application/json")
    @Transactional
    @Path("/tag={id}&page={page}")
    public Response findAllByTag(@PathParam("id") Long id, @PathParam("page") int page) {
        Set<Game> games = gameService.findAllByTag(id, page);
        // todo check what status to return???
        return Response
                .status(Response.Status.OK)
                .entity(games)
                .build();
    }

    @GET
    @Produces("application/json")
    @Transactional
    @Path("/developer={id}&page={page}")
    public Response findAllByDeveloper(@PathParam("id") Long id, @PathParam("page") int page) {
        Set<Game> games = gameService.findAllByDeveloper(id, page);
        // todo check what status to return???
        return Response
                .status(Response.Status.OK)
                .entity(games)
                .build();
    }

    @GET
    @Produces("application/json")
    @Transactional
    @Path("/platform={id}&page={page}")
    public Response findAllByPlatform(@PathParam("id") Long id, @PathParam("page") int page) {
        Set<Game> games = gameService.findAllByPlatform(id, page);
        // todo check what status to return???
        return Response
                .status(Response.Status.OK)
                .entity(games)
                .build();
    }
}