package health.d_health_api.serviceImpls;

import health.d_health_api.dto.requests.CreateProfileDto;
import health.d_health_api.dto.responses.ProfileDto;
import health.d_health_api.model.*;
import health.d_health_api.repositories.*;
import health.d_health_api.services.AuthService;
import health.d_health_api.services.ProfileService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public void createProfile(CreateProfileDto createProfileDto,String token) {
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
                .bloodPressures(bloodPressures)
                .glucoseLevels(glucoseLevels)
                .hartRates(hartRates)
                .otherDetails(createProfileDto.getOtherDetails())
                .build();
        Profile save = profileRepository.save(profile);
        glucoseLevels.forEach(glucoseLevel -> glucoseLevel.setProfile(save));
    }

    @Override
    public Profile getProfileDetails() {
        return  null;
    }

    @Override
    public List<ProfileDto> getProfiles() {
        return profileRepository.findAll().stream().map(ProfileDto::fromProfile).collect(Collectors.toList());
    }
}
