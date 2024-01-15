package ru.netology.cloud.security.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class WebSecurityConfig {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("Kirill").password("{noop}12654").roles("NOT_ALL")
//                .and()
//                .withUser("Ivan").password("{noop}password").authorities("read", "write")
//                .and()
//                .withUser("user").password("{noop}1234").authorities("read");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .and()
//                .authorizeRequests().antMatchers("/").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/read").hasAuthority("read")
//                .and()
//                .authorizeRequests().antMatchers("/write").hasAuthority("write")
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
//    }
}