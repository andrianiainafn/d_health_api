package health.d_health_api.services;

import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.dto.responses.CreatePassionResponseDto;
import health.d_health_api.map.TokenDetailsMap;
import org.springframework.security.oauth2.jwt.Jwt;

import java.time.Instant;

public interface AuthService {
    Jwt decodeToken(String token);
    void generateScopeAndSubjectWithPasswordGrand(String email, String password, TokenDetailsMap tokenDetailsMap);
    void generateScopeAndSubjectWithRefreshTokenGrand(String refreshToken,String email, String password, TokenDetailsMap tokenDetailsMap);
    String generateRefreshToken(String scope, Instant instant);
    String generateToken(String subject,Instant instant,boolean withRefreshToken , String passionId);

    String generateToken(String scope, String subject, Instant instant, boolean withRefreshToken, String passionId);

    CreatePassionResponseDto registerPassion(CreatePassionRequestDto createPassionRequest);
}
