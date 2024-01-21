package health.d_health_api.map;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TokenDetailsMap {
    private String scope;
    private String subject;
    private String userId;
}
