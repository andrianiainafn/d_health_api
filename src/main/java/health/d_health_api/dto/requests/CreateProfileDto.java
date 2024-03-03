package health.d_health_api.dto.requests;

import health.d_health_api.enums.BloodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class CreateProfileDto {

    private BloodType bloodType;
    private String diseasesChronic;
    private String allergy;
    private String otherDetails;
    private String currentSymptoms;
    private List<String> hartRates;
    private List<String> bloodPressures;
    private List<String> glucoseLevels;
}
