package health.d_health_api.repositories;

import health.d_health_api.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<String, Appointment> {

}
