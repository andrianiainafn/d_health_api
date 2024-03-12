package health.d_health_api.controller;


import health.d_health_api.dto.requests.AppointmentRequestDto;
import health.d_health_api.model.Appointment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {

    @PostMapping("")
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto,@RequestHeader (name = HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
}
