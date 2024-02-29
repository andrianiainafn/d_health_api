package health.d_health_api.dto.responses;

import health.d_health_api.model.Passion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePassionResponseDto {
    private String username;
    private String email;
    private String token;
}
