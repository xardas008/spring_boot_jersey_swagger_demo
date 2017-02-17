package com.example

import org.springframework.stereotype.Component

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces

/**
 * Created by dkreuter on 17.02.17.
 */
@Path("/")
@Component
class GreetingsController {

    @Path("/greeting/{name}")
    @GET
    @Produces("application/json")
    public Greeting greeting(@PathParam("name") String name) {
        Greeting greeting = new Greeting()
        greeting.setName("Hello " + name);
        return greeting
    }
}
