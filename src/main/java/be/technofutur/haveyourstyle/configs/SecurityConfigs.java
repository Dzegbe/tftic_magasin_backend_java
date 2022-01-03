package be.technofutur.haveyourstyle.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity()
public class SecurityConfigs extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable()
        .authorizeRequests()
        .anyRequest().permitAll()
        .and().httpBasic();

        http.headers()
            .frameOptions()
            .disable();
    }
}
