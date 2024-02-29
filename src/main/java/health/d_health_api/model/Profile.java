package health.d_health_api.model;

import health.d_health_api.enums.BloodType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String profile_id;
    private BloodType bloodType;
    private String diseasesChronic;
    private String allergy;
    private String otherDetails;
    private String currentSymptoms;

    @ManyToOne
    private Passion passion;
    @OneToMany(mappedBy = "profile")
    private List<HartRate> hartRates;
    @OneToMany(mappedBy = "profile")
    private List<BloodPressure> bloodPressures;
    @OneToMany(mappedBy = "profile")
    private List<GlucoseLevel> glucoseLevels;

    private Date modifyAt;
    private Date createdAt;
}
