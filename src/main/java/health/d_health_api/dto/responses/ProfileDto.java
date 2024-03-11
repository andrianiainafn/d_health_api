package health.d_health_api.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import health.d_health_api.enums.BloodType;
import health.d_health_api.model.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDto {
    private String profileId;
    private BloodType bloodType;
    private String diseasesChronic;
    private String allergy;
    private String otherDetails;
    private String currentSymptoms;
    private Date modifyAt;
    private Date createdAt;
    private List<HartRate> hartRates;
    private List<BloodPressure> bloodPressures;
    private List<GlucoseLevel> glucoseLevels;

    public static ProfileDto fromProfile(Profile profile){
        return  ProfileDto.builder()
                .profileId(profile.getProfileId())
                .allergy(profile.getAllergy())
                .bloodType(profile.getBloodType())
                .hartRates(profile.getHartRates())
                .bloodPressures(profile.getBloodPressures())
                .currentSymptoms(profile.getCurrentSymptoms())
                .glucoseLevels(profile.getGlucoseLevels())
                .otherDetails(profile.getOtherDetails())
                .diseasesChronic(profile.getDiseasesChronic())
                .createdAt(profile.getCreatedAt())
                .modifyAt(profile.getModifyAt())
                .build();
    }
}
