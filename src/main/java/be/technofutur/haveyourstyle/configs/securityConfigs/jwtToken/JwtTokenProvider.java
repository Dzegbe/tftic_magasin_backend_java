package be.technofutur.haveyourstyle.configs.securityConfigs.jwtToken;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import be.technofutur.haveyourstyle.models.entities.User;


@Component
public class JwtTokenProvider {
    private final UserDetailsService userDetails;

    JwtTokenProvider(UserDetailsService userDetails){
        this.userDetails = userDetails;
    }

    public String createToken(User user){
        return JwtConst.TOKEN_PREFIX + JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtConst.EXPIRATION_TIME))
                .withClaim("roles",user.getRoles())
                .sign((Algorithm.HMAC512(JwtConst.JWT_KEY)));        
    }
    /**
     * Permet la suppression du prefixe du token pour éviter lors de la lecture une erreur
     * @param request
     * @return String
     * @
     */
    public String resolveToken(HttpServletRequest request){
        String token = request.getHeader(JwtConst.HEADER_KEY);
        //regarder si le token recois quelquechose et si le prefixe est le bon 
        if(token != null && token.startsWith(JwtConst.TOKEN_PREFIX) ){
            return token.substring(JwtConst.TOKEN_PREFIX.length());
        }
        return null;
    }

    public boolean validateToken(String token){
        try{
            //décrypter
            DecodedJWT jwtDecode = JWT.require(Algorithm.HMAC512(JwtConst.JWT_KEY))
                                      .build()
                                      .verify(token.replace(JwtConst.TOKEN_PREFIX, ""));
            //récupération du de l'username
            String username = jwtDecode.getSubject();
            //récupération de la date d'expiration
            Date exp = jwtDecode.getExpiresAt();

            //verification des parametre pour la validiter du token
            return username != null && exp != null && exp.after(new Date(System.currentTimeMillis()));
        }
        catch(JWTVerificationException e){
            return false;
        }
    }

    public Authentication authentication(String token){
        String username = JWT.decode(token.replace(JwtConst.TOKEN_PREFIX,"")).getSubject();
        UserDetails userDetails = this.userDetails.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(),null,userDetails.getAuthorities());
    }
}
