package personal.myfirstwebapi.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{
private Contact contact() {
    return new Contact(
            "Your name",
            "http://www.yourwebsite.com", 
            "you@yourwebsite.com");
    }

    private ApiInfoBuilder buildApiInfo() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Title - Rest API");
        apiInfoBuilder.description("Sample API for using Spring Boot REST API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Terms of Use: Open Source");
        apiInfoBuilder.license("License - Your Company");
        apiInfoBuilder.licenseUrl("http://www.yourwebsite.com");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detailApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
     
        docket
        .select()
        .apis(RequestHandlerSelectors.basePackage("personal.myfirstwebapi.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(this.buildApiInfo().build())
        .consumes(new HashSet<String>(Arrays.asList("application/json")))
        .produces(new HashSet<String>(Arrays.asList("application/json")));
        
        return docket;
    }


}