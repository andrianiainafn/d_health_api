package health.d_health_api.controller;

import health.d_health_api.dto.requests.CreateProfileDto;
import health.d_health_api.model.Profile;
import health.d_health_api.services.ProfileService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class PassionProfileController {
    private final ProfileService profileService;

    public PassionProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("create")
    public ResponseEntity<Profile> createNewProfile(@RequestBody CreateProfileDto createProfileDto, @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorizationHeader){
        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            Profile profile = profileService.createProfile(createProfileDto,token);
            return new ResponseEntity<>(profile, HttpStatus.CREATED) ;
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
