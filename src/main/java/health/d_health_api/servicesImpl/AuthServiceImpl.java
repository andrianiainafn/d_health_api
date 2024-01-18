package health.d_health_api.servicesImpl;

import health.d_health_api.map.TokenDetailsMap;
import health.d_health_api.services.AuthService;
import org.springframework.security.oauth2.jwt.Jwt;

import java.time.Instant;

public class AuthServiceImpl implements AuthService {
    @Override
    public Jwt decodeToken(String token) {
        return null;
    }

    @Override
    public void generateScopeAndSubjectWithPasswordGrand(String email, String password, TokenDetailsMap tokenDetailsMap) {

    }

    @Override
    public void generateScopeAndSubjectWithRefreshTokenGrand(String email, String password, TokenDetailsMap tokenDetailsMap) {

    }

    @Override
    public String generateRefreshToken(String scope, Instant instant) {
        return null;
    }

    @Override
    public String generateToken(String scope, String subject, Instant instant, boolean withRefreshToken, Long userId) {
        return null;
    }
}
