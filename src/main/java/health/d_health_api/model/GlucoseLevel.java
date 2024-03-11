package health.d_health_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class GlucoseLevel {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String glucoseLevelId;
    private double level;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Profile profile;

    private Date measureDate;
}
