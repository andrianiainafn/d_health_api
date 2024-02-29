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
public class HartRate {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String hartRateId;
    private int rate;

    @ManyToOne
    private Profile profile;

    private Date measureDate;
}
