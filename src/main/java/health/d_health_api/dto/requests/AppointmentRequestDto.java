package health.d_health_api.dto.requests;

import health.d_health_api.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequestDto {
    private AppointmentStatus appointmentStatus;
    private LocalDateTime appointmentDateTime;
    private String medicalDoctor;
    private String instructions;
}
