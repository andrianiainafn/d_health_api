package health.d_health_api.services;

import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.model.Passion;
import health.d_health_api.repositories.PassionRepository;
import health.d_health_api.servicesImpl.AuthServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.UUID;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Mock
    private PassionRepository passionRepository;
    @InjectMocks
    private AuthServiceImpl authService;
    private Passion passion;
    private CreatePassionRequestDto createPassionRequestDto;

    @BeforeEach
    void  init(){
        createPassionRequestDto = CreatePassionRequestDto.builder()
                .username("Yor")
                .dateOfBirth(new Date())
                .email("yor@gmail.com")
                .password("admin")
                .build();
        passion = Passion.builder()
                .passionId(UUID.randomUUID().toString())
                .username("Yor")
                .dateOfBirth(new Date())
                .email("yor@gmail.com")
                .createdAt(new Date())
                .modifyAt(new Date())
                .password(mockPasswordEncoder.encode("admin"))
                .build();
    }

    @Test
    public void AuthService_RegisterPassion_ReturnCreatePassionRequestDto(){
        //arrange
        when(mockPasswordEncoder.encode("admin")).thenReturn("encodedAdmin");
        when(passionRepository.save(any())).thenReturn(passion);
        //act
        CreatePassionRequestDto savedPassion = authService.registerPassion(createPassionRequestDto);
        //assert
        verify(passionRepository, times(1)).save(any());
        Assertions.assertThat(savedPassion).isNotNull();
    }
}