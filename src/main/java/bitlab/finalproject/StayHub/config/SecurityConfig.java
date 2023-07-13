package bitlab.finalproject.StayHub.config;

import bitlab.finalproject.StayHub.Service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig  {


  @Bean
  public UserService securityUserService() {
    return new UserService();
  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder builder
        =  http.getSharedObject(AuthenticationManagerBuilder.class);
    builder.userDetailsService(securityUserService()).passwordEncoder(passwordEncoder());
    //UserService будет использован в качестве главного  ервиса пользователя

    http.exceptionHandling().accessDeniedPage("/access-denied-page-403");
    http.formLogin().loginPage("/sign-in-page")
        .loginProcessingUrl("/to-enter") // <form action = "/to-enter" method = "post">
        .usernameParameter("user_email") // <input type = "email" name = "user_email">
        .passwordParameter("user_password") // <input type = "password" name = "user_password">
        .defaultSuccessUrl("/") // reponse.sendRedirect("/profile")
        .failureUrl("/sign-in-page?AuthError");
    http.logout()
        .logoutUrl("/sign-out")
        .logoutSuccessUrl("/sign-in-page");

    http.csrf().disable();

    return http.build();
  }
}
