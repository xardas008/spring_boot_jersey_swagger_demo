package com.example

import io.swagger.jaxrs.listing.ApiListingResource
import io.swagger.jaxrs.listing.SwaggerSerializers
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration

/**
 * Created by dkreuter on 17.02.17.
 */
@Configuration
class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        register(GreetingsController)
        register(ApiListingResource)
        register(SwaggerSerializers)
    }
}
