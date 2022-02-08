package be.technofutur.haveyourstyle.configs.mailConfigs;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.stereotype.Component;

import be.technofutur.haveyourstyle.configs.JwtConst;
import be.technofutur.haveyourstyle.models.entities.Customer;

@Component
public class JwtTokenProviderMail {

    public String creatTokenMail(String verificationCode) {
        return JwtConst.TOKEN_PREFIX + JWT.create()
            .withSubject(verificationCode)
            .withExpiresAt(new Date(System.currentTimeMillis() + JwtConst.EXPIRATION_TIME_MAIL))
            .sign(Algorithm.HMAC512(JwtConst.JWT_KEY));  
    }

    public boolean  toCheckCode(String token, String codeToCheck){
       try
       { 
           DecodedJWT jwtDecode = JWT.require(Algorithm.HMAC512(JwtConst.JWT_KEY))
                                  .build()
                                  .verify(token.replace(JwtConst.TOKEN_PREFIX, ""));
        
            String verificationCode = jwtDecode.getSubject();
            Date exp = jwtDecode.getExpiresAt();

            return verificationCode != null && exp != null && exp.after(new Date(System.currentTimeMillis()))
                && verificationCode.equals(codeToCheck);
            
        }catch(JWTDecodeException e){
            return false;
        }
        
    }
    
}
