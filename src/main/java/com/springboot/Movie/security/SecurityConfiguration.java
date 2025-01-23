package com.springboot.Movie.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){
        JdbcUserDetailsManager jdbcUserDetailsManager =  new JdbcUserDetailsManager(datasource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id = ?");
        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/actor").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/actor/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/actor").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/actor").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/actor/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET,"/director").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/director/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/director").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/director").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/director/**").hasRole("ADMIN")


                        .requestMatchers(HttpMethod.GET,"/movie").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/movie/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/movie").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/movie").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/movie/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET,"/movie/movie-details/**").hasAnyRole("MANAGER,ADMIN,EMPLOYEE")
        );


        http.httpBasic(Customizer.withDefaults());

        //Cross site request forgery....(CSRF)
        //csrf is for the web app
        //for building non browser clients csrf is not required POST,PUT,DELETE,GET...

        http.csrf(csrf-> csrf.disable());

        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails tarun = User.builder()
//                .username("tarun")
//                .password("{noop}101")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails kishor = User.builder()
//                .username("kishor")
//                .password("{noop}102")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails aakash = User.builder()
//                .username("aaksah")
//                .password("{noop}103")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(tarun,kishor,aakash);
//    }

}
