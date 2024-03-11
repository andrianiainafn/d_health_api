package health.d_health_api.controller;

import health.d_health_api.dto.requests.CreateGlucoseLevelRequest;
import health.d_health_api.model.GlucoseLevel;
import health.d_health_api.services.GlucoseLevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/glucose-level")
public class GlucoseLevelController {
    private final GlucoseLevelService glucoseLevelService;

    public GlucoseLevelController(GlucoseLevelService glucoseLevelService) {
        this.glucoseLevelService = glucoseLevelService;
    }
    @PostMapping ("{profileId}")
    public ResponseEntity<GlucoseLevel> createNewGlucoseLevel(@RequestBody CreateGlucoseLevelRequest createGlucoseLevelRequest, @PathVariable String profileId){
        GlucoseLevel glucoseLevel = glucoseLevelService.createGlucoseLevel(createGlucoseLevelRequest, profileId);
        return new ResponseEntity<>(glucoseLevel, HttpStatus.CREATED);
    }
    @GetMapping("")
    public  ResponseEntity<List<GlucoseLevel>> getGlucoseLevels(){
        return new ResponseEntity<>(glucoseLevelService.getAllGlucoseLevels(),HttpStatus.OK);
    }
}
