package health.d_health_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class GlucoseLevel {

    @Id
    @GeneratedValue
    private String glucoseLevelId;
    private double level;

    @ManyToOne
    private Profile profile;

    private Date measureDate;
}
