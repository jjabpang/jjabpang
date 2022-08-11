package com.dongnae.jjabpang.config.jwt;

import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.exception.CustomJwtRuntimeException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 *packageName    : com.dongnae.jjabpang.config.jwt
 * fileName       : JwtTokenProvider
 * author         : ipeac
 * date           : 2022-08-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-11        ipeac       최초 생성
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class JwtTokenProvider {
      private final JwtProperties jwtProperties;
      
      public String generateToken(User user) {
            Date now = new Date();
            return Jwts.builder()
                       .setHeader(createHeader())   // (1)
                       .setClaims(createClaims(user))  // (2)
                       .setIssuedAt(now)  // (3)
                       .setExpiration(new Date(now.getTime() + Duration.ofHours(3)
                                                                       .toMillis())) // (4)
                       .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())  // (5)
                       .compact();
      }
      
      private Map<String, Object> createHeader() {
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256"); // 해시 256 암호화
            return header;
      }
      
      private Map<String, Object> createClaims(User user) { // payload
            Map<String, Object> claims = new HashMap<>();
            claims.put("userNo", user.getUserNo());
            claims.put("email", user.getEmail());
            return claims;
      }
      
      private Claims getClaims(String token) throws CustomJwtRuntimeException {
            try {
                  return Jwts.parser()
                             .setSigningKey(jwtProperties.getSecret())
                             .parseClaimsJws(token)
                             .getBody();
                  // 토큰 유효성 확인
            } catch (SecurityException e) {
                  log.info("Invalid JWT signature.");
                  throw new CustomJwtRuntimeException("Invalid JWT signature.");
            } catch (MalformedJwtException e) {
                  log.info("Invalid JWT token.");
                  throw new CustomJwtRuntimeException("Invalid JWT token.");
            } catch (ExpiredJwtException e) {
                  log.info("Expired JWT token.");
                  throw new CustomJwtRuntimeException("Expired JWT token.");
            } catch (UnsupportedJwtException e) {
                  log.info("Unsupported JWT token.");
                  throw new CustomJwtRuntimeException("Unsupported JWT token.");
            } catch (IllegalArgumentException e) {
                  log.info("JWT token compact of handler are invalid.");
                  throw new CustomJwtRuntimeException("JWT token compact of handler are invalid.");
            }
      }
      
      /**
       * 이메일 get
       */
      public String getUserEmailFromToken(String token) throws CustomJwtRuntimeException {
            return (String) getClaims(token).get("email");
      }
      
      /**
       * 유저번호 get
       */
      
      public Long getUserNoFromToken(String token) throws CustomJwtRuntimeException {
            return (Long) getClaims(token).get("userNo");
      }
}