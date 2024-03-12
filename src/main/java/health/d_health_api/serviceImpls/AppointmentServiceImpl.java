package health.d_health_api.serviceImpls;

import health.d_health_api.dto.requests.AppointmentRequestDto;
import health.d_health_api.model.Appointment;
import health.d_health_api.repositories.AppointmentRepository;
import health.d_health_api.services.AppointmentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private  final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment createAppointment(AppointmentRequestDto appointmentRequestDto,String token) {
        Appointment.builder()
                .appointmentStatus(appointmentRequestDto.getAppointmentStatus())
                .medicalDoctor(appointmentRequestDto.getMedicalDoctor())
                .instructions(appointmentRequestDto.getInstructions() )
                .appointmentDateTime(appointmentRequestDto.getAppointmentDateTime())
                .build();
        return null;
    }
}
