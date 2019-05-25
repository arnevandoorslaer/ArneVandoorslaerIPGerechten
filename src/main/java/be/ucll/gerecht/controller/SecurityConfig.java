package be.ucll.gerecht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .mvcMatchers("/css/bootstrap.css").permitAll()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/*").permitAll()
                .mvcMatchers("/dagmenu/*").permitAll()
                .mvcMatchers("/weekMenu").permitAll()
                .mvcMatchers("/gerechten/").hasAnyRole("USER", "ADMIN")
                .mvcMatchers("/gerechten/**").hasRole("ADMIN")
                .mvcMatchers("/gerechten/***").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().loginProcessingUrl("/login_succes").loginPage("/login").permitAll()
                .and().logout().logoutUrl("/logout")
                .deleteCookies("JSESSIONID");
        httpSecurity.csrf().disable();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER").and()
                .withUser("admin").password("{noop}admin").roles("ADMIN");

    }
}
