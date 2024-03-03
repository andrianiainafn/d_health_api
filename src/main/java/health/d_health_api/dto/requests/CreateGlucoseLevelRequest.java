package health.d_health_api.dto.requests;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGlucoseLevelRequest {
    private double level;
    private String profileId;
    private Date measureDate;
}