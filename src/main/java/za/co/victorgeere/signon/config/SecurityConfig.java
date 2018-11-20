package za.co.victorgeere.signon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().and().authorizeRequests()
                .antMatchers("/h2/**").permitAll()
                .antMatchers("/api/user/**").permitAll()
                .antMatchers("/api/users/**").hasRole("USER")
                .and()
                    .csrf().ignoringAntMatchers("/h2/**")
                .and()
                    .headers().frameOptions().sameOrigin()
                .and()
                    .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
                .withUser("user").password("asdf").roles("USER")
                .and()
                .withUser("admin").password("asdf").roles("ADMIN", "USER");
    }

}
