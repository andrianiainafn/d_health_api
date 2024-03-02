package health.d_health_api.servicesImpl;

import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.dto.requests.LoginPassionDto;
import health.d_health_api.dto.responses.AuthPassionResponseDto;
import health.d_health_api.exceptions.RessourceNotFoundException;
import health.d_health_api.map.TokenDetailsMap;
import health.d_health_api.model.Passion;
import health.d_health_api.repositories.PassionRepository;
import health.d_health_api.services.AuthService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    JwtEncoder jwtEncoder;
    JwtDecoder jwtDecoder;
    PassionRepository passionRepository;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;

    @Override
    public Jwt decodeToken(String token) {
        return null;
    }

    @Override
    public String generateRefreshToken(String scope, Instant instant,String subject) {
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(subject)
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
    public AuthPassionResponseDto registerPassion(CreatePassionRequestDto createPassionRequest) {
        Passion passion = Passion.builder()
                .passionId(UUID.randomUUID().toString())
                .modifyAt(new Date())
                .createdAt(new Date())
                .dateOfBirth(createPassionRequest.getDateOfBirth())
                .username(createPassionRequest.getUsername())
                .email(createPassionRequest.getEmail())
                .password(passwordEncoder.encode(createPassionRequest.getPassword()))
                .build();
        Passion passionSaved =passionRepository.save(passion);
        return AuthPassionResponseDto.builder()
                .token(this.generateToken("", createPassionRequest.getEmail(), Instant.now(),true,passionSaved.getPassionId()))
                .email(createPassionRequest.getEmail())
                .username(createPassionRequest.getUsername())
                .refreshToken(this.generateRefreshToken("",Instant.now(),createPassionRequest.getEmail()))
                .build();
    }

    @Override
    public AuthPassionResponseDto loginPassion(LoginPassionDto loginPassionDto) throws RessourceNotFoundException {
        String token = "";
        String passionId ="";
        String subject = "";
        if(loginPassionDto.getGrandType().equals("password")){
            System.out.println(loginPassionDto.getEmail());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginPassionDto.getEmail(), loginPassionDto.getPassword())
            );
            System.out.println(authentication);
            subject = authentication.getName();
            passionId = passionRepository.findPassionByEmail(subject).getPassionId();

        }else if(loginPassionDto.getGrandType().equals("refreshToken")){
            Jwt decodeJwt = null;
            try {
                decodeJwt = jwtDecoder.decode(loginPassionDto.getRefreshToken());
            } catch (JwtException e) {
                throw  new RessourceNotFoundException("Token is required!");
            }
            subject = decodeJwt.getSubject();
            passionId = passionRepository.findPassionByEmail(subject).getPassionId();
        }
        token = this.generateToken("",subject,Instant.now(),true,passionId);
        return AuthPassionResponseDto.builder()
                .token(token)
                .refreshToken(this.generateRefreshToken("",Instant.now(),subject))
                .build();
    }
}
