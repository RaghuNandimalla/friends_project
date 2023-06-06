package com.information.friends.professional_info.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfessionalConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
