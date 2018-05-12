package com.niit.springwebexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
      .withUser("ad1").password("admin123").roles("USER");
      auth.inMemoryAuthentication().withUser("ad2").password("admin123").roles("USER");
      auth.inMemoryAuthentication().withUser("ad3").password("admin123").roles("USER");
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().antMatchers("/").hasRole("USER")
      .and()
      .httpBasic();
   }
   
   @SuppressWarnings("deprecation")
   @Bean
   public static NoOpPasswordEncoder passwordEncoder() {
   return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
   }
}