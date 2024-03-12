package health.d_health_api.model;

import health.d_health_api.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String appointmentId;
    private AppointmentStatus appointmentStatus;
    private LocalDateTime appointmentDateTime;
    private String medicalDoctor;
    private String instructions;

    @ManyToOne
    private Profile profile;
}
