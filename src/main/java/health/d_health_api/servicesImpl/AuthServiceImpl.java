package health.d_health_api.servicesImpl;

import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.map.TokenDetailsMap;
import health.d_health_api.model.Passion;
import health.d_health_api.repositories.PassionRepository;
import health.d_health_api.services.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final PassionRepository passionRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(PassionRepository passionRepository, PasswordEncoder passwordEncoder) {
        this.passionRepository = passionRepository;
        this.passwordEncoder = passwordEncoder;
    }

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
        return null;
    }

    @Override
    public String generateToken(String scope, String subject, Instant instant, boolean withRefreshToken, Long userId) {
        return null;
    }

    @Override
    public CreatePassionRequestDto registerPassion(CreatePassionRequestDto createPassionRequest) {
        Passion passion = Passion.builder()
                .passionId(UUID.randomUUID().toString())
                .modifyAt(new Date())
                .createdAt(new Date())
                .dateOfBirth(new Date())
                .username(createPassionRequest.getUsername())
                .email(createPassionRequest.getEmail())
                .password(passwordEncoder.encode(createPassionRequest.getPassword()))
                .build();
        Passion savePassion = passionRepository.save(passion);
        return CreatePassionRequestDto.fromPassion(savePassion);
    }
}
