package com.example.gamedex.webapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/instrumentation")
public class InstrumentationApi {

    @GET
    @Produces("application/json")
    @Path("/ping")
    public String ping() {
        return "pong";
    }
}
