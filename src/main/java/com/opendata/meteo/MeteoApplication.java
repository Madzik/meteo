package com.opendata.meteo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@OpenAPIDefinition( info = @Info(title = " Meteo Api", description = "Meteo Data"))
public class MeteoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MeteoApplication.class, args);
    }

}
