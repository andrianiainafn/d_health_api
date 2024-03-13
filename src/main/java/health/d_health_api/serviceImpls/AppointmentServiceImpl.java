package health.d_health_api.serviceImpls;

import health.d_health_api.dto.requests.AppointmentRequestDto;
import health.d_health_api.enums.AppointmentStatus;
import health.d_health_api.model.Appointment;
import health.d_health_api.model.Passion;
import health.d_health_api.repositories.AppointmentRepository;
import health.d_health_api.repositories.PassionRepository;
import health.d_health_api.services.AppointmentService;
import health.d_health_api.services.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private  final AppointmentRepository appointmentRepository;
    private final PassionRepository passionRepository;
    private final AuthService authService;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PassionRepository passionRepository, AuthService authService) {
        this.appointmentRepository = appointmentRepository;
        this.passionRepository = passionRepository;
        this.authService = authService;
    }

    @Override
    public Appointment createAppointment(AppointmentRequestDto appointmentRequestDto,String token) {
        Passion passion = passionRepository.findByPassionId(authService.decodeToken(token));
        Appointment appointment = Appointment.builder()
                .appointmentStatus(appointmentRequestDto.getAppointmentStatus())
                .medicalDoctor(appointmentRequestDto.getMedicalDoctor())
                .instructions(appointmentRequestDto.getInstructions() )
                .passion(passion)
                .appointmentDateTime(appointmentRequestDto.getAppointmentDateTime())
                .build();
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getListOfAppointmentForPassion(String token, AppointmentStatus status) {
        if(status.equals(AppointmentStatus.ALL)){
            return appointmentRepository.findAppointmentByPassion_PassionId(authService.decodeToken(token));
        }else{
            return appointmentRepository.findAppointmentByAppointmentStatusAndPassion_PassionId(status, authService.decodeToken(token));
        }
    }
}
