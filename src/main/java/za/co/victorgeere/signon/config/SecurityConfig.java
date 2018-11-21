package za.co.victorgeere.signon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import za.co.victorgeere.signon.user.H2UserDetailsService;

@EnableWebSecurity
public class SecurityConfig {

    public static class SecureApiConfiguratorAdapter extends WebSecurityConfigurerAdapter {
        @Autowired
        H2UserDetailsService userDetailsService;

        @Override
        public void configure(AuthenticationManagerBuilder builder) throws Exception {
            builder.userDetailsService(userDetailsService);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/users").permitAll().and().csrf().disable();
            http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/logout").permitAll().and().csrf().disable();

            http.httpBasic().and().authorizeRequests().anyRequest().authenticated()
                    .antMatchers(HttpMethod.GET,"/api/users/**").hasRole("USER").and().csrf().disable();

            http.authorizeRequests().antMatchers("/h2/**").permitAll()
                    .and()
                    .csrf().ignoringAntMatchers("/h2/**")
                    .and()
                    .headers().frameOptions().sameOrigin()
                    .and()
                    .csrf().disable();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder(12);
        }
    }

}
