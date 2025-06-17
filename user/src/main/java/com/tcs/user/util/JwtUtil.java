package com.tcs.user.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.function.Function;

public class JwtUtil {

  private static final String SECRET_KEY = "secretkey123456";
  private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

  public static String generateToken(String subject) {
    return Jwts
      .builder()
      .setSubject(subject)
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
      .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
      .compact();
  }

  public static Boolean validateToken(String token, String subject) {
    final String username = extractUsername(token);
    return (username.equals(subject) && !isTokenExpired(token));
  }

  public static String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public static Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  public static <T> T extractClaim(
    String token,
    Function<Claims, T> claimsResolver
  ) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private static Claims extractAllClaims(String token) {
    return Jwts
      .parser()
      .setSigningKey(SECRET_KEY)
      .parseClaimsJws(token)
      .getBody();
  }

  private static Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }
}
