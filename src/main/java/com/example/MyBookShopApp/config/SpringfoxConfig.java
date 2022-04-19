package com.example.MyBookShopApp.config;


import io.swagger.annotations.Api;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.xml.namespace.QName;
import java.util.ArrayList;

@Configuration
public class SpringfoxConfig {

    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfo(
                "Bookshop API",
                "API for bookstore",
                "1.0",
                "http://www.termsofservice.org",
                new Contact("API owner","http://www.ownersite.com","owner@rmailer.org"),
                "api_license",
                "http://www.license.edu.org",
                new ArrayList<>()
        );
    }
}
