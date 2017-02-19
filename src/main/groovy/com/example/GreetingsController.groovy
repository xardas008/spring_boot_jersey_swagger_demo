package com.example

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
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
@Api(value = "Greetings Controller", produces = "application/json")
class GreetingsController {

    @Path("/greeting/{name}")
    @GET
    @Produces("application/json")
    @ApiOperation(value = "Greets the caller",
            notes = "Provide your name as parameter and see what happens.",
            response = Greeting.class)

        @ApiResponse(
                code = 200, message = "Successful")
    public Greeting greeting(@ApiParam(value = "The person who should be greeted.", required = false) @PathParam("name") String name) {
        Greeting greeting = new Greeting()
        greeting.setName("Hello " + name);

        return greeting
    }
}
