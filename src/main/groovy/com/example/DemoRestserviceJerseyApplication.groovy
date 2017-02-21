package com.example

import io.swagger.jaxrs.config.BeanConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2 // needs to be present so that swagger ui will show up the API's
class DemoRestserviceJerseyApplication {

	static void main(String[] args) {
		SpringApplication.run DemoRestserviceJerseyApplication, args
	}

    @Bean
    public BeanConfig beanConfig()  {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes("http");
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/example");
        beanConfig.setResourcePackage("com.example")    // needs to be the base package of the API documentation.
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true)
        return beanConfig;
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(
                "validatorUrl",// url
                "none",       // docExpansion          => none | list
                "alpha",      // apiSorter             => alpha
                "schema",     // defaultModelRendering => schema
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
                false,        // enableJsonEditor      => true | false
                true,         // showRequestHeaders    => true | false
                60000L)      // requestTimeout => in milliseconds, defaults to null (uses jquery xh timeout)
    }

}
