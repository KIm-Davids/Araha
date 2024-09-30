package com.semicolon.africa.arahasubcriptionapp.Utils;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserRegisterResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


@Component
public class JwtUtilsImpl implements JwtUtils{

    private JwtUtilsImpl jwtUtils;

    @SneakyThrows
    @Override
    public String generateToken(String userName, String phoneNumber, String email, String password) {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(userName)
                .claim("phoneNumber",phoneNumber)
                .claim("email", email)
                .claim("password", password)
                .claim("subscriptionType", SubscriptionType.NOT_SET)
                .issueTime(new Date())
                .expirationTime(new Date((System.currentTimeMillis()) + 3600 *1000))
                .build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
        signedJWT.sign(new MACSigner(secretKey));
        return signedJWT.serialize();
    }


    public JWTClaimsSet extractClaims(String token) {
        try{
            SignedJWT signedJWT = SignedJWT.parse(token);
            return signedJWT.getJWTClaimsSet();
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public Object extractEmail(String token, UserRegisterRequest request) {
        Map<String, Object> claims = extractClaims(token).getClaims();
        for(Map.Entry<String, Object> entry : claims.entrySet()){
            if("phoneNumber".equals(entry.getKey())){
                return entry.getValue();
            }
        }
            throw new RuntimeException("User details not found");
    }

    public String extractPassword(String token) {
        JWTClaimsSet claimsSet = extractClaims(token);
        Object password = claimsSet.getClaim("password");
        return password.toString();
    }


    public String extractPhoneNumber(String token) throws ParseException {
        return extractClaims(token).getStringClaim("phoneNumber");
    }

    public boolean isTokenExpired(String token){
        long milliSecond = System.currentTimeMillis();
        Date expirationDate = new Date(milliSecond + 3600 * 1000);
        return extractClaims(token).getExpirationTime().before(expirationDate);
    }

    @Override
    public boolean validateToken(String token, String userName) {
        return (userName.equals(extractUsername(token)) && !isTokenExpired(token));

    }
}
