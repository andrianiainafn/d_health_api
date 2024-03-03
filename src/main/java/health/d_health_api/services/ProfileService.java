package health.d_health_api.services;

import health.d_health_api.dto.requests.CreateProfileDto;
import health.d_health_api.model.Profile;

public interface ProfileService {
    Profile createProfile (CreateProfileDto profile, String token);
    void getProfileDetails ();
}
