package health.d_health_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import health.d_health_api.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String appointmentId;
    private AppointmentStatus appointmentStatus;
    private LocalDateTime appointmentDateTime;
    private String medicalDoctor;
    private String instructions;

    @JsonIgnore
    @ManyToOne
    private Passion passion;
}
