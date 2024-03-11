package health.d_health_api.controller;

import health.d_health_api.dto.requests.CreateBloodPressureRequest;
import health.d_health_api.model.BloodPressure;
import health.d_health_api.services.BloodPressureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blood-pressure")
public class BloodPressureController {
    private  final BloodPressureService bloodPressureService;

    public BloodPressureController(BloodPressureService bloodPressureService) {
        this.bloodPressureService = bloodPressureService;
    }
    @PostMapping("/{profileId}")
    public ResponseEntity<BloodPressure> createNewBloodPressure(@PathVariable String profileId, @RequestBody CreateBloodPressureRequest createBloodPressureRequest){
        BloodPressure bloodPressure = bloodPressureService.createBloodPressure(createBloodPressureRequest,profileId);
        return  new ResponseEntity<>(bloodPressure, HttpStatus.CREATED);
    }
}
