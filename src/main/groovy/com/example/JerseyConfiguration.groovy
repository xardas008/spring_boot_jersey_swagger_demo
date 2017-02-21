package com.example

import io.swagger.jaxrs.listing.ApiListingResource
import io.swagger.jaxrs.listing.SwaggerSerializers
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration

import javax.ws.rs.ApplicationPath

/**
 * Jersey configuration class.
 */
@Configuration
@ApplicationPath("/example")
class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        register(GreetingsController)
        register(ApiListingResource)
        register(SwaggerSerializers)
    }
}
