package com.edu.upc.FondoMiVivienda.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("FondoMiViviendaMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }

    @Bean
    public ReportMapper reportMapper(){
        return new ReportMapper();
    }

}
