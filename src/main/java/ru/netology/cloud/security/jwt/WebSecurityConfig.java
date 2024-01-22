package ru.netology.cloud.security.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// CORS
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// CORS


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

//    @Bean
//    JdbcUserDetailsManager users(DataSource dataSource, PasswordEncoder encoder) {
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(encoder.encode("password"))
//                .roles("ADMIN")
//                .build();
//        UserDetails cust = User.builder()
//                .username("cust")
//                .password(encoder.encode("cust"))
//                .roles("CUST")
//                .build();
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
////        jdbcUserDetailsManager.createUser(admin);
////        jdbcUserDetailsManager.createUser(cust);
//        return jdbcUserDetailsManager;
//    }

 //4 Test

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(auth -> auth
                        .requestMatchers("*").permitAll()
                )
                .httpBasic(Customizer.withDefaults())  //??
                .formLogin(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .build();
    }

    //5TRest

//    @Bean
//    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
//        return http
//                .authorizeRequests(auth -> auth
//                        .dispatcherTypeMatchers(HttpMethod.valueOf("/")).permitAll()
//                        .requestMatchers("/login").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults())  //??
//                .formLogin(Customizer.withDefaults())
//                .csrf(csrf -> csrf.disable())
//                .cors(Customizer.withDefaults())
//                .build();
//    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // CORS
    @Configuration
    @EnableWebMvc
    class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowCredentials(true)
                    .allowedOrigins("http://localhost:8081")
                    .allowedOrigins("http://192.168.99.100:8081")
                    .allowedOrigins("http://192.168.1.145:8081")
//                    .allowedOrigins("http://192.168.99.100")
//                    .allowedOrigins("http://192.168.1.89")
//                  .allowedOrigins("*")
                    .allowedMethods("*");
        }
    }

    // CORS

}