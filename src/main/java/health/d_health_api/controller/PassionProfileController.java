package health.d_health_api.controller;

import health.d_health_api.dto.requests.CreateProfileDto;
import health.d_health_api.dto.responses.ProfileDto;
import health.d_health_api.model.Profile;
import health.d_health_api.services.ProfileService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/profile")
public class PassionProfileController {
    private final ProfileService profileService;

    public PassionProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/create")
    public ResponseEntity<Profile> createNewProfile(@RequestBody CreateProfileDto createProfileDto, @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorizationHeader){
        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
             profileService.createProfile(createProfileDto,token);
            return new ResponseEntity<>( HttpStatus.CREATED) ;
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("")
    public ResponseEntity<List<ProfileDto>> getAllProfiles() {
        List<ProfileDto> profiles = profileService.getProfiles();
        return new ResponseEntity<>(profiles,   HttpStatus.OK);
    }
}
