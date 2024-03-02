package health.d_health_api.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginPassionDto {
    private String password;
    private String email;
    private String grandType;
    private String refreshToken;
}
