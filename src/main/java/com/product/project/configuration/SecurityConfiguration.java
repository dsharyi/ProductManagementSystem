package com.product.project.configuration;

import com.product.project.services.UserDetailedServiceImpl;
import com.product.project.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailedServiceImpl userDetailedService(UserService userService) {
        return new UserDetailedServiceImpl(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .antMatchers("/", "/startpage", "/registration", "/register").permitAll()
                .antMatchers("/product/list").hasAnyRole("USER", "ADMIN")
                .antMatchers("/product/**", "/user/**").hasRole("ADMIN")
                .antMatchers("/jpeg/**").authenticated()
                .antMatchers("/**").authenticated()
                .anyRequest().denyAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/main")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .and()
                .csrf().disable();
    }

}
