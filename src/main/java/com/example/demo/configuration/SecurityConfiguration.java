package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/kategorie").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/rejestracja").permitAll()
                .antMatchers("/przepisy").permitAll()
                .antMatchers("/przepis").permitAll()
                .antMatchers("/**/*.css").permitAll()
                .antMatchers("/edytacja").hasRole("USER")
                .antMatchers("/dodawanie").hasRole("USER")
                .antMatchers("/dodawanie-skladniki").hasRole("USER")
                .antMatchers("/edytuj-skladnik").hasRole("USER")
                .antMatchers("/h2-console/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().ignoringAntMatchers("/edytowanie/**")
                .and()
                .csrf().ignoringAntMatchers("/przepis/**")
                .and()
                .csrf().ignoringAntMatchers("/edytuj-skladnik/**")
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**")
                .and()
                .csrf().ignoringAntMatchers("//**")
                .and()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password,enabled from user_data where username=?")
                .authoritiesByUsernameQuery("select username, role from user_role where username=?");
    }
}