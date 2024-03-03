package health.d_health_api.serviceImpls;

import health.d_health_api.dto.requests.CreateHartRateRequest;
import health.d_health_api.model.HartRate;
import health.d_health_api.model.Profile;
import health.d_health_api.repositories.HartRateRepository;
import health.d_health_api.repositories.PassionRepository;
import health.d_health_api.repositories.ProfileRepository;
import health.d_health_api.services.AuthService;
import health.d_health_api.services.HartRateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HartRateServiceImpl implements HartRateService {
    private final HartRateRepository hartRateRepository;
    private final ProfileRepository profileRepository;


    public HartRateServiceImpl(HartRateRepository hartRateRepository, AuthService authService, PassionRepository passionRepository, ProfileRepository profileRepository) {
        this.hartRateRepository = hartRateRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public void createHartRate(CreateHartRateRequest hartRateRequest, String profileId) {
        Profile profile = profileRepository.findByProfileId(profileId);
        HartRate.builder()
                .rate(hartRateRequest.getRate())
                .measureDate(hartRateRequest.getMeasureDate())
                .profile(profile)
                .build();
    }
}
