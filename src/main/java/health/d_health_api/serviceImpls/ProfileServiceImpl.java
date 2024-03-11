package health.d_health_api.serviceImpls;

import health.d_health_api.dto.requests.CreateProfileDto;
import health.d_health_api.model.*;
import health.d_health_api.repositories.*;
import health.d_health_api.services.AuthService;
import health.d_health_api.services.ProfileService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final PassionRepository passionRepository;
    private final AuthService authService;
    private final HartRateRepository hartRateRepository;
    private final BloodPressureRepository bloodPressureRepository;
    private final GlucoseLevelRepository glucoseLevelRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository, PassionRepository passionRepository, AuthService authService, HartRateRepository hartRateRepository, BloodPressureRepository bloodPressureRepository, GlucoseLevelRepository glucoseLevelRepository) {
        this.profileRepository = profileRepository;
        this.passionRepository = passionRepository;
        this.authService = authService;
        this.hartRateRepository = hartRateRepository;
        this.bloodPressureRepository = bloodPressureRepository;
        this.glucoseLevelRepository = glucoseLevelRepository;
    }

    @Override
    public Profile createProfile(CreateProfileDto createProfileDto,String token) {
        Passion passion = passionRepository.findByPassionId(authService.decodeToken(token));
        List<HartRate> hartRates = hartRateRepository.findAllByHartRateIdIsIn(createProfileDto.getHartRates());
        List<BloodPressure> bloodPressures = bloodPressureRepository.findAllByBloodPressureIdIn(createProfileDto.getBloodPressures());
        List<GlucoseLevel> glucoseLevels = glucoseLevelRepository.findAllByGlucoseLevelIdIsIn(createProfileDto.getGlucoseLevels());
        Profile profile = Profile.builder()
                .currentSymptoms(createProfileDto.getCurrentSymptoms())
                .createdAt(new Date())
                .passion(passion)
                .bloodType(createProfileDto.getBloodType())
                .allergy(createProfileDto.getAllergy())
                .diseasesChronic(createProfileDto.getDiseasesChronic())
                .otherDetails(createProfileDto.getOtherDetails())
                .hartRates(hartRates)
                .glucoseLevels(glucoseLevels)
                .bloodPressures(bloodPressures)
                .build();
        return  profileRepository.save(profile);
    }

    @Override
    public void getProfileDetails() {

    }
}
