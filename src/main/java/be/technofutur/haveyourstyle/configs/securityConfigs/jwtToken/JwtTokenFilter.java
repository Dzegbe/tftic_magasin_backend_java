package be.technofutur.haveyourstyle.configs.securityConfigs.jwtToken;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtTokenFilter extends OncePerRequestFilter{
    
    private final JwtTokenProvider provider;


    public JwtTokenFilter(JwtTokenProvider provider) {
        this.provider = provider;
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String token = provider.resolveToken(request);

        if(token != null && provider.validateToken(token)){
            Authentication auth = provider.authentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);

    }
    
}
