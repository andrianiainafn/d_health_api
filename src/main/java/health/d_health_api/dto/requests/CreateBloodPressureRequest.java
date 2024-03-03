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
public class CreateBloodPressureRequest {
    private int systolic;
    private int diastolic;
    private String profileId;
    private Date measureDate;
}