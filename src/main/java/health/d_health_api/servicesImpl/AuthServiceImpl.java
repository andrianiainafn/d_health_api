package health.d_health_api.servicesImpl;

import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.dto.responses.CreatePassionResponseDto;
import health.d_health_api.map.TokenDetailsMap;
import health.d_health_api.model.Passion;
import health.d_health_api.repositories.PassionRepository;
import health.d_health_api.services.AuthService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    JwtEncoder jwtEncoder;
    JwtDecoder jwtDecoder;
    PassionRepository passionRepository;
    PasswordEncoder passwordEncoder;



    @Override
    public Jwt decodeToken(String token) {
        return null;
    }

    @Override
    public void generateScopeAndSubjectWithPasswordGrand(String email, String password, TokenDetailsMap tokenDetailsMap) {

    }

    @Override
    public void generateScopeAndSubjectWithRefreshTokenGrand(String refreshToken,String email, String password, TokenDetailsMap tokenDetailsMap) {

    }

    @Override
    public String generateRefreshToken(String scope, Instant instant) {
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuedAt(instant)
                .issuer("health-security")
                .expiresAt(instant.plus(15  , ChronoUnit.DAYS))
                .claim("scope",scope)
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    }

    @Override
    public String generateToken(String scope, String subject, Instant instant, boolean withRefreshToken, String passionId) {
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(subject)
                .id(passionId)
                .issuedAt(instant)
                .issuer("health-security")
                .expiresAt(instant.plus(withRefreshToken ? 10 : 15 , ChronoUnit.DAYS))
                .claim("scope",scope)
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    }

    @Override
    public CreatePassionResponseDto registerPassion(CreatePassionRequestDto createPassionRequest) {
        Passion passion = Passion.builder()
                .passionId(UUID.randomUUID().toString())
                .modifyAt(new Date())
                .createdAt(new Date())
                .dateOfBirth(createPassionRequest.getDateOfBirth())
                .username(createPassionRequest.getUsername())
                .email(createPassionRequest.getEmail())
                .password(passwordEncoder.encode(createPassionRequest.getPassword()))
                .build();
        passionRepository.save(passion);
        return CreatePassionResponseDto.builder()
                .token(this.generateToken("","",Instant.now(),true,""))
                .email(createPassionRequest.getEmail())
                .username(createPassionRequest.getUsername())
                .refreshToken(this.generateRefreshToken("",Instant.now()))
                .build();
    }
}
