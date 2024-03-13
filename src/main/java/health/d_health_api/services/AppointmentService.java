package health.d_health_api.services;

import health.d_health_api.dto.requests.AppointmentRequestDto;
import health.d_health_api.enums.AppointmentStatus;
import health.d_health_api.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(AppointmentRequestDto appointmentRequestDto,String token);
    List<Appointment> getListOfAppointmentForPassion(String token, AppointmentStatus status);
}
