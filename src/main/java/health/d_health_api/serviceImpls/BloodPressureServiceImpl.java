package health.d_health_api.serviceImpls;

import health.d_health_api.dto.requests.CreateBloodPressureRequest;
import health.d_health_api.model.BloodPressure;
import health.d_health_api.model.Profile;
import health.d_health_api.repositories.BloodPressureRepository;
import health.d_health_api.repositories.ProfileRepository;
import health.d_health_api.services.BloodPressureService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BloodPressureServiceImpl implements BloodPressureService {
    private final ProfileRepository profileRepository;
    private final BloodPressureRepository bloodPressureRepository;

    public BloodPressureServiceImpl(ProfileRepository profileRepository, BloodPressureRepository bloodPressureRepository) {
        this.profileRepository = profileRepository;
        this.bloodPressureRepository = bloodPressureRepository;
    }

    @Override
    public  BloodPressure createBloodPressure(CreateBloodPressureRequest bloodPressureRequest, String profileId) {
        Profile profile = profileRepository.findByProfileId(profileId);
        BloodPressure bloodPressure = BloodPressure.builder()
                .profile(profile)
                .diastolic(bloodPressureRequest.getDiastolic())
                .systolic(bloodPressureRequest.getSystolic())
                .measureDate(bloodPressureRequest.getMeasureDate())
                .build();
        BloodPressure bloodPressureSaved =bloodPressureRepository.save(bloodPressure);
        profile.getBloodPressures().add(bloodPressureSaved);
        return bloodPressureSaved;
    }
}
