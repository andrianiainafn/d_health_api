package health.d_health_api.services;

import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.dto.requests.LoginPassionDto;
import health.d_health_api.dto.responses.AuthPassionResponseDto;
import health.d_health_api.exceptions.RessourceNotFoundException;
import health.d_health_api.map.TokenDetailsMap;
import org.springframework.security.oauth2.jwt.Jwt;

import java.time.Instant;

public interface AuthService {
    Jwt decodeToken(String token);
    String generateRefreshToken(String scope, Instant instant,String subject);
    String generateToken(String scope, String subject, Instant instant, boolean withRefreshToken, String passionId);

    AuthPassionResponseDto registerPassion(CreatePassionRequestDto createPassionRequest);
    AuthPassionResponseDto loginPassion(LoginPassionDto loginPassionDto) throws RessourceNotFoundException;
    
}
