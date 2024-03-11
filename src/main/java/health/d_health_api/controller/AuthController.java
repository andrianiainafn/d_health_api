package health.d_health_api.controller;

import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.dto.requests.LoginPassionDto;
import health.d_health_api.dto.responses.AuthPassionResponseDto;
import health.d_health_api.exceptions.RessourceNotFoundException;
import health.d_health_api.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthPassionResponseDto> createNewPassion(@RequestBody CreatePassionRequestDto createPassionRequestDto){
        return new ResponseEntity<>(authService.registerPassion(createPassionRequestDto), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthPassionResponseDto> loginPassion(@RequestBody LoginPassionDto loginPassionDto) throws RessourceNotFoundException {
        return new ResponseEntity<>(authService.loginPassion(loginPassionDto), HttpStatus.OK);
    }
    @GetMapping("/test")
    public  ResponseEntity<String> getTest(){
        return new ResponseEntity<>("je test", HttpStatus.OK);
    }
}
