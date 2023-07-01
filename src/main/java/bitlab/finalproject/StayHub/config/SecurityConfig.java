package bitlab.finalproject.StayHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


//    http.exceptionHandling().accessDeniedPage("/access-denied-page-403");
//    AuthenticationManagerBuilder builder=http.getSharedObject(AuthenticationManagerBuilder.class);
//    builder.userDetailsService(securityUserService()).passwordEncoder(passwordEncoder);
    http.formLogin().loginPage("/Signin")
         .loginProcessingUrl("/to-enter") // <form action = "/to-enter" method = "post">
        .usernameParameter("user_email") // <input type = "email" name = "user_email">
        .passwordParameter("user_password") // <input type = "password" name = "user_password">
        .defaultSuccessUrl("/profile") // reponse.sendRedirect("/profile")
        .failureUrl("/sign-in-page?autherror")


    http.csrf().disable();

  return http.build();
  }
}
