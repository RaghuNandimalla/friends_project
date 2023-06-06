package com.information.friends.basic_information.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
public class PersonConfiguration {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
