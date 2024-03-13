package health.d_health_api.repositories;

import health.d_health_api.enums.AppointmentStatus;
import health.d_health_api.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
    List<Appointment> findAppointmentByPassion_PassionId(String passionId);
    List<Appointment> findAppointmentByAppointmentStatusAndPassion_PassionId(AppointmentStatus appointmentStatus, String passionId);
}
