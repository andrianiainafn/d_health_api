package health.d_health_api.services;

import health.d_health_api.dto.requests.CreateProfileDto;
import health.d_health_api.dto.responses.ProfileDto;
import health.d_health_api.model.Profile;

import java.util.List;

public interface ProfileService {
    void createProfile (CreateProfileDto profile, String token);
    Profile getProfileDetails ();
    List<ProfileDto> getProfiles ();
}
