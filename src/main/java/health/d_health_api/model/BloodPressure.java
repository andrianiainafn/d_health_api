package health.d_health_api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class BloodPressure {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String bloodPressureId;
    private int systolic;
    private int diastolic;

    @ManyToOne
    private Profile profile;

    private Date measureDate;
}
