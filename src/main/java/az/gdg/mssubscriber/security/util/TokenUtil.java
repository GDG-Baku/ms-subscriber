package az.gdg.mssubscriber.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {
    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);
    private final Clock clock = DefaultClock.INSTANCE;
    @Value("${jwt.secret}")
    private String secret;

    public String generateTokenWithEmail(String email) {
        logger.info("UtilLog.generateTokenWithEmail.start : email {}", email);
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        logger.info("UtilLog.generateTokenWithEmail.stop.success : email {}", email);
        return doGenerateTokenWithEmailL(claims);
    }

    public String doGenerateTokenWithEmailL(Map<String, Object> claims) {
        logger.info("UtilLog.generateTokenWithEmail.start");
        Date createdDate = clock.now();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(createdDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Claims getAllClaimsFromToken(String token) {
        logger.info("UtilLog.getAllClaimsFromToken.start : token {}", token);
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getEmailFromToken(String token) {
        logger.info("UtilLog.getEmailFromToken.start : token {}", token);
        String email = getAllClaimsFromToken(token).get("email").toString();
        logger.info("UtilLog.getEmailFromToken.start.success : token {}", token);
        return email;
    }
}
