package com.semicolon.africa.arahasubcriptionapp.Utils;

import com.nimbusds.jwt.JWTClaimsSet;

public interface JwtUtils {

    String generateToken(String userName, String email, String phoneNumber, String password);
    String extractUsername(String token);
    JWTClaimsSet extractClaims (String token);
    boolean validateToken(String token, String username);
}
