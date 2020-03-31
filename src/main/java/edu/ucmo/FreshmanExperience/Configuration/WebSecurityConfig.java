package edu.ucmo.FreshmanExperience.Configuration;

import edu.ucmo.FreshmanExperience.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/info").permitAll()
                .antMatchers("/").hasAnyAuthority("USER","ADMIN")
                .antMatchers("/sessions").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/sessions/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/sessions").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/sessions/**").hasAuthority("ADMIN")
                .antMatchers("/users").hasAuthority("ADMIN")
                .and()
                .formLogin()
                .usernameParameter("user_name")
                .passwordParameter("password")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();
        http
            .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
