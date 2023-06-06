package com.information.friends.basic_information.security;

import net.bytebuddy.build.Plugin;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class PersonSecurity extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = this.getPasswordEncoder();
        auth.inMemoryAuthentication().withUser("Raghu").password(passwordEncoder.encode("Raghu@004")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("Sowmya").password(passwordEncoder.encode("Sowmya@004")).roles("MANAGER");
        auth.inMemoryAuthentication().withUser("Venu").password(passwordEncoder.encode("Venu@004")).roles("PERSON");
        auth.inMemoryAuthentication().withUser("Vikram").password(passwordEncoder.encode("Vikram@004")).roles("PERSON");
        auth.inMemoryAuthentication().withUser("Uppi").password(passwordEncoder.encode("Uppi@004")).roles("PERSON");
        auth.inMemoryAuthentication().withUser("Vishnu").password(passwordEncoder.encode("Vishnu@004")).roles("PERSON");
        auth.inMemoryAuthentication().withUser("Anvesh").password(passwordEncoder.encode("Anvesh@004")).roles("PERSON");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/basic_information-api/").permitAll()
                .antMatchers("/basic_information-api/persons").hasAnyRole("ADMIN","MANAGER","PERSON")
                .antMatchers("/basic_information-api/MANAGER").hasAnyRole("ADMIN","MANAGER")
                .antMatchers("/basic_information-api/ADMIN").hasRole("ADMIN")
                .and()
                .formLogin();
    }
}
