package health.d_health_api.controller;

import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<CreatePassionRequestDto> createNewPassion(CreatePassionRequestDto createPassionRequestDto){
        return new ResponseEntity<>(authService.registerPassion(createPassionRequestDto), HttpStatus.CREATED);
    }
}