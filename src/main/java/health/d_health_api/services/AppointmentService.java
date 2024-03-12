package health.d_health_api.services;

import health.d_health_api.dto.requests.AppointmentRequestDto;
import health.d_health_api.model.Appointment;

public interface AppointmentService {
    Appointment createAppointment(AppointmentRequestDto appointmentRequestDto,String token);
}
