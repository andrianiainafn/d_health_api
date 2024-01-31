package health.d_health_api.controller;

import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.model.Passion;
import health.d_health_api.servicesImpl.AuthServiceImpl;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Date;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ExtendWith (MockitoExtension.class)
@AllArgsConstructor
class AuthControllerTest {


    private MockMvc mockMvc;
    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Mock
    private AuthServiceImpl authService;

    @InjectMocks
    private AuthController authController;
    private Passion passion;
    private CreatePassionRequestDto createPassionRequestDto;

    @BeforeEach
    public void init(){
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
    public void AuthController_RegisterPassion_ReturnCreated() throws Exception {
        //arrange
        when(mockPasswordEncoder.encode("admin")).thenReturn("encodedAdmin");
        given(authService.registerPassion(any())).willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
//        when((authService.registerPassion(any()))).thenReturn(CreatePassionRequestDto.fromPassion(passion));
        //act
        ResultActions response = mockMvc.perform(post("/api/auth/register"));
        //assert
    }

}