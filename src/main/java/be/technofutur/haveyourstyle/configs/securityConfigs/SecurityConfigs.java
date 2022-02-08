package be.technofutur.haveyourstyle.configs.securityConfigs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import be.technofutur.haveyourstyle.configs.securityConfigs.jwtToken.JwtTokenFilter;
import be.technofutur.haveyourstyle.configs.securityConfigs.jwtToken.JwtTokenProvider;

@Configuration
@EnableWebSecurity()
public class SecurityConfigs extends WebSecurityConfigurerAdapter {

   
    private final JwtTokenProvider provider;

    

    public SecurityConfigs(JwtTokenProvider provider) {
        this.provider = provider;
    }

    // cryptage du password
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable();

        //rendre mon sessionmanagement statelesse
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

        //donner les autorisations
        http.authorizeRequests()
        .antMatchers("/h2-console/**").permitAll()
        .antMatchers(HttpMethod.POST,"/login").permitAll()
        .antMatchers(HttpMethod.POST,"/register","/registerCustomer","/registerSellerInd",
                "/registerSellerPro").permitAll()
        .antMatchers(HttpMethod.GET,"/verifyCustomer").permitAll()
        .antMatchers(HttpMethod.POST,"/brand/**","/article/**").hasAnyAuthority("SELLER")
        .antMatchers(HttpMethod.PUT,"/brand/**","/article/**").hasAnyAuthority("SELLER")
        .antMatchers(HttpMethod.DELETE,"/brand/**","/article/**").hasAnyAuthority("SELLER")
        .anyRequest().authenticated();


        //ajouter le tokenFilter
        http.addFilterBefore(
           new JwtTokenFilter(provider), UsernamePasswordAuthenticationFilter.class);


        http.headers()
            .frameOptions()
            .disable();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("http://localhost:4200/");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addExposedHeader("Authorization");
        corsConfiguration.setAllowCredentials(true);

        return request -> corsConfiguration;
    }


    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

   
}
