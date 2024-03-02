package health.d_health_api.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthPassionResponseDto {
    private String username;
    private String email;
    private String token;
    private String refreshToken;
}
