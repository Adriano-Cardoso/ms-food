package br.com.adrianofood.payment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.adrianofood.payment"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Microsserviço de pagamento", "Plataforma de delivery "
                , "v1", "Terms Of Service Url",
                new Contact("Adriano Cardoso", "https://github.com/Adriano-Cardoso",
                        "goularta97@gmail.com"), "Liscense of API", "License of URL",
                Collections.emptyList());
    }

    @Bean
    SecurityScheme oauth() {
        return new OAuthBuilder().name("OAuth2").scopes(scopes()).build();
    }

    private List<AuthorizationScope> scopes() {
        List<AuthorizationScope> list = new ArrayList<>();
        list.add(new AuthorizationScope("read", "Grants read access"));
        list.add(new AuthorizationScope("write", "Grants write access"));
        return list;
    }
}
