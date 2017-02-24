# Spring Boot Jersey Rest Service documentation with Swagger 

This example demonstrates how to document your JAX-RS API (using Jersey as implementation) with Swagger and Springfox UI 
for visualization.

For integrating Swagger in your project, please follow the following steps.

## Dependencies

You'll need the following dependencies:

### Maven

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.6.1</version>
</dependency>

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.6.1</version>
</dependency>

<dependency>
    <groupId>io.swagger</groupId>
	<artifactId>swagger-jersey2-jaxrs</artifactId>
	<version>1.5.12</version>
</dependency>
```

### Gradle

```groovy
compile('io.springfox:springfox-swagger2:2.6.1')
compile('io.springfox:springfox-swagger-ui:2.6.1')
compile('io.swagger:swagger-jersey2-jaxrs:1.5.12')
```

## Application.java \ Application.groovy

Annotate your entry class with @EnableSwagger2 to enable Springfox Swagger.

Next, you need to define two Beans.

```groovy
@Bean
public BeanConfig beanConfig()  {
    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0.2"); // Version of your API
    beanConfig.setSchemes("http");  // Supported protocol, http or https
    beanConfig.setHost("localhost:8080");
    beanConfig.setBasePath("/example"); // base path of your service.
    beanConfig.setResourcePackage("com.example")    // needs to be the base package of the API documentation.
    beanConfig.setScan(true);
    beanConfig.setPrettyPrint(true)
    return beanConfig;
}

@Bean
UiConfiguration uiConfig() {
    return new UiConfiguration(
        "validatorUrl",// url
        "none",       // docExpansion          => none | list, full
        "alpha",      // apiSorter             => alpha
        "schema",     // defaultModelRendering => schema, model
        UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
        false,        // enableJsonEditor      => true | false
        true,         // showRequestHeaders    => true | false
        60000L)      // requestTimeout => in milliseconds, defaults to null (uses jquery xh timeout)
}
```

After that, you can annotate your api with the Swagger Annotations.

To access the Swagger UI go to \<protocol\>://\<server\>:\<port\>/swagger-ui.html
