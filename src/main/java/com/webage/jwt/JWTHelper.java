package com.webage.jwt;

import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class JWTHelper {
	
	public static String createToken(String scopes) {
		
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    long tenHoursInMillis = 1000 * 60 * 60 * 10;
		    Date expireDate = new Date(System.currentTimeMillis() + tenHoursInMillis);
		    String token = JWT.create()
		    	.withSubject("apiuser")
		        .withIssuer("me@me.com")
		        .withClaim("scopes", scopes)
		        .withExpiresAt(expireDate)
		        .sign(algorithm);
		    return token;
		} catch (JWTCreationException exception){
			return null;
		}	
	}

}
