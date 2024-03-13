package health.d_health_api.controller;


import health.d_health_api.dto.requests.AppointmentRequestDto;
import health.d_health_api.enums.AppointmentStatus;
import health.d_health_api.model.Appointment;
import health.d_health_api.services.AppointmentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("")
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto,@RequestHeader (name = HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            return  new ResponseEntity<>(appointmentService.createAppointment(appointmentRequestDto,token),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<List<Appointment>> getAppointmentForPassion(@RequestHeader (name = HttpHeaders.AUTHORIZATION) String authorizationHeader, @RequestParam AppointmentStatus status){
        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            return  new ResponseEntity<>(appointmentService.getListOfAppointmentForPassion(token,status),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
