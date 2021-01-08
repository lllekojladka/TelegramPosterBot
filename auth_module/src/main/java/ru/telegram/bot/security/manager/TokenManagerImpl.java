package ru.telegram.bot.security.manager;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.telegram.bot.config.SecurityConfig;
import ru.telegram.bot.model.User;
import ru.telegram.bot.security.manager.api.TokenManager;
import ru.telegram.bot.util.ClockUtil;
import ru.telegram.bot.util.JsonUtil;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenManagerImpl implements TokenManager {

    private final SecurityConfig securityConfig;
    private final ClockUtil clockUtil;


    @Override
    public String generateAccessToken(User user) {
        return Jwts.builder()
                .setSubject(JsonUtil.toJson(user))
                .setIssuer(securityConfig.getJwtIssuer())
                .setIssuedAt(clockUtil.getCurrentDate())
                .setExpiration(clockUtil.getCurrentDatePlusSec(securityConfig.getLifeTimeToken()))
                .signWith(securityConfig.getSignatureAlgorithm(), securityConfig.getJwtSecret())
                .compact()
                ;
    }


    @Override
    public User getUser(String token) {
        String subject = Jwts.parser()
                .setSigningKey(securityConfig.getJwtSecret())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return JsonUtil.fromJson(subject, User.class);
    }


    @Override
    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(securityConfig.getJwtSecret()).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature - {}", ex.getMessage());
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token - {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token - {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token - {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty - {}", ex.getMessage());
        }
        return false;
    }
}
