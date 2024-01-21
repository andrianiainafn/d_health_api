package health.d_health_api.dto.requests;

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
public class CreatePassionRequestDto {
    private String username;
    private String email;
    private String password;
    private Date dateOfBirth;

    public static CreatePassionRequestDto fromPassion(Passion passion){
        return CreatePassionRequestDto.builder()
                .password(passion.getPassword())
                .email(passion.getEmail())
                .dateOfBirth(passion.getDateOfBirth())
                .username(passion.getUsername())
                .build();
    }
}
