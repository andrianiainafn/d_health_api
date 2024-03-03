package health.d_health_api.serviceImpls;

import health.d_health_api.dto.requests.CreateGlucoseLevelRequest;
import health.d_health_api.model.GlucoseLevel;
import health.d_health_api.model.Profile;
import health.d_health_api.repositories.GlucoseLevelRepository;
import health.d_health_api.repositories.ProfileRepository;
import health.d_health_api.services.GlucoseLevelService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GlucoseLevelServiceImpl implements GlucoseLevelService {
    private final ProfileRepository profileRepository;
    private final GlucoseLevelRepository glucoseLevelRepository;

    public GlucoseLevelServiceImpl(ProfileRepository profileRepository, GlucoseLevelRepository glucoseLevelRepository) {
        this.profileRepository = profileRepository;
        this.glucoseLevelRepository = glucoseLevelRepository;
    }

    @Override
    public void createGlucoseLevel(CreateGlucoseLevelRequest glucoseLevelRequest, String profileId) {
        Profile profile = profileRepository.findByProfileId(profileId);
        GlucoseLevel.builder()
                .level(glucoseLevelRequest.getLevel())
                .measureDate(glucoseLevelRequest.getMeasureDate())
                .profile(profile)
                .build();
    }
}
