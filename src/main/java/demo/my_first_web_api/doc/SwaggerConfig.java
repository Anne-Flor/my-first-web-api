package demo.my_first_web_api.doc;

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
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebFlux
@EnableSwagger2WebMvc
public class SwaggerConfig {
    private Contact contato(){
        return new Contact(
                "Seu nome", 
                "http://www.seusite.com.br",
                "você@seusite.com.br"); 
    }

private ApiInfoBuilder informacoesapi(){
    ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
    apiInfoBuilder.title("Title - Rest API");
    apiInfoBuilder.description("API - SPring Boot REST API");
    apiInfoBuilder.version("1.0");
    apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
    apiInfoBuilder.license("Licença - Empresa");
    apiInfoBuilder.licenseUrl("www.suaempresa.com.br");
    apiInfoBuilder.contact(this.contato());

    return apiInfoBuilder;
    }

@Bean
public Docket detalheApi() {
    Docket docket = new Docket(DocumentationType.SWAGGER_2);

    docket
    .select()
    .apis(RequestHandlerSelectors.basePackage("pacote.comseus.controller"))
    .paths(PathSelectors.any())
    .build()
    .apiInfo(this.informacoesapi().build())
    .consumes(new HashSet<String>(Arrays.asList("aplication/JSON")))
    .produces(new HashSet<String>(Arrays.asList("aplication/JSON")));

    return docket; 
}
}
