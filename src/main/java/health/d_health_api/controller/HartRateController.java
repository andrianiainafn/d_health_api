package health.d_health_api.controller;

import health.d_health_api.dto.requests.CreateHartRateRequest;
import health.d_health_api.model.HartRate;
import health.d_health_api.services.HartRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/hart-rate")
public class HartRateController {
    private final HartRateService hartRateService;

    public HartRateController(HartRateService hartRateService) {
        this.hartRateService = hartRateService;
    }
    @PostMapping ("{profileId}")
    public ResponseEntity<HartRate> createNewHartRate(@PathVariable String profileId, @RequestBody CreateHartRateRequest hartRateRequest){
        HartRate hartRate = hartRateService.createHartRate(hartRateRequest, profileId);
        return new ResponseEntity<>(hartRate, HttpStatus.CREATED);
    }
}
