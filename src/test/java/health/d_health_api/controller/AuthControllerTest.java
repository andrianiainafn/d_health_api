package health.d_health_api.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.servicesImpl.AuthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Date;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private AuthServiceImpl authService;

    @InjectMocks
    private AuthController authController;

    private MockMvc mockMvc;

    private CreatePassionRequestDto createPassionRequestDto;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
        objectMapper = new ObjectMapper();
        createPassionRequestDto = CreatePassionRequestDto.builder()
                .username("Yor")
                .dateOfBirth(new Date())
                .email("yor@gmail.com")
                .password("admin")
                .build();
    }

    @Test
    public void AuthController_RegisterPassion_ReturnCreated() throws Exception {
        // Arrange
        given(authService.registerPassion(any())).willReturn(createPassionRequestDto);

        // Act & Assert
        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPassionRequestDto)))
                .andExpect(status().isCreated());
    }
}
