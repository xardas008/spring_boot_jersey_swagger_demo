package com.example

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.ResponseHeader
import org.springframework.stereotype.Component

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.xml.ws.Response

/**
 * Created by dkreuter on 17.02.17.
 */
@Path("/")
@Component
@Api(value = "Test of Swagger")
class GreetingsController {

    @Path("/greeting/{name}")
    @GET
    @Produces("application/json")
    @ApiOperation(value = "Finds Pets by status",
            notes = "Multiple status values can be provided with comma seperated strings",
            response = Greeting.class,
            responseContainer = "List")

        @ApiResponse(
                code = 400, message = "Invalid ID supplied",
                responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used",
                        response = Greeting.class))

    public Greeting greeting(@ApiParam(value = "name that need to be updated", required = true) @PathParam("name") String name) {
        Greeting greeting = new Greeting()
        greeting.setName("Hello " + name);

        return greeting
    }
}
