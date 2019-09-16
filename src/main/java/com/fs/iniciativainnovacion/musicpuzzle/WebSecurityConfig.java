package com.fs.iniciativainnovacion.musicpuzzle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        http
                .authorizeRequests()
                .antMatchers("/puzzle")
                .permitAll();

        http.authorizeRequests().antMatchers("/puzzle1success","/yetanotherpuzzle")
                .hasAnyAuthority("PUZZLE2","PUZZLE3");

        http.authorizeRequests().antMatchers("/puzzle2success","/isthislastpuzzle")
                .hasAnyAuthority("PUZZLE3");

        http.authorizeRequests().antMatchers("/puzzle3success")
                .hasAnyAuthority("ALLCLEARED");

        http
                .authorizeRequests()
                .antMatchers("/puzzle3")
                .permitAll();
        http
                .authorizeRequests()
                .antMatchers("/puzzle4")
                .permitAll();
    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}