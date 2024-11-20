package com.ecommerce.config;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	private static final Logger logger = LogManager.getLogger(JwtTokenProvider.class);
	@Value("${app.jwt-secret}")
	private String jwtSecret;
	@Value("${app.expiration}")
	private long jwtExpiration;

	public String generateToken(Authentication auth) {
		String username = ((UserDetails) auth.getPrincipal()).getUsername();
		Date current = new Date();
		Date expired = new Date(current.getTime() + jwtExpiration);
		String token = Jwts.builder().subject(username).issuedAt(current).expiration(expired).signWith(key()).compact();
		return token;
	}

	private Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}

	public String getUsername(String token) {
		return Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(token).getPayload().getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().verifyWith((SecretKey) key()).build().parse(token);
			return true;
		} catch (Exception e) {
			logger.error("Exception :: " + e);
		}
		return false;
	}
}
