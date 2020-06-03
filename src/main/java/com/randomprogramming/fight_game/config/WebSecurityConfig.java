package com.randomprogramming.fight_game.config;

import com.randomprogramming.fight_game.service.PlayerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    PlayerDetailsService playerDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // tell spring boot which service to use for authentication and which password encoder to use
        auth.userDetailsService(playerDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/login", "/api/register", "/api/logout", "/api/me").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/api/login")
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    // Override the default authentication handler and do nothing in it. Since we're not in a browser,
                    // redirecting the user causes issues.
                })
                .failureHandler((httpServletRequest, httpServletResponse, e) ->
                        httpServletResponse.getWriter().append("Login failed."))
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
