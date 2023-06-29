package com.edu.upc.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class OpenApiConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins("https://finance-s-project.web.app/").allowedMethods("*").allowedHeaders("*");
    }

    @Bean
    public OpenAPI customOpenApi(
            @Value("${documentation.application.description}")
            String applicationDescription,
            @Value("${documentation.application.version}")
            String applicationVersion
    ){
        return new OpenAPI()
                .info(new Info()
                        .title("Finanzas's MyApp")
                        .version(applicationVersion)
                        .description(applicationDescription)
                        .termsOfService("https://MyAppFinanzas.com")
                        .license(new License()
                                .name("Apache 2.0 License")
                                .url("https://MyAppFinanzas.com/license"))
                        .contact(new Contact()
                                .name("MyApp, .Finanzas")
                                .url("https://MyAppFinanzas.com")));
    }
}
