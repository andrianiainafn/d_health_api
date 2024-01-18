package health.d_health_api.services;

import health.d_health_api.map.TokenDetailsMap;
import org.springframework.security.oauth2.jwt.Jwt;

import java.time.Instant;

public interface AuthService {
    Jwt decodeToken(String token);
    void generateScopeAndSubjectWithPasswordGrand(String email, String password, TokenDetailsMap tokenDetailsMap);
    void generateScopeAndSubjectWithRefreshTokenGrand(String email, String password, TokenDetailsMap tokenDetailsMap);
    String generateRefreshToken(String scope, Instant instant);
    String generateToken(String scope,String subject,Instant instant,boolean withRefreshToken , Long userId);
}
