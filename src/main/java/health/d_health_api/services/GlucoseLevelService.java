package health.d_health_api.services;

import health.d_health_api.dto.requests.CreateGlucoseLevelRequest;
import health.d_health_api.model.GlucoseLevel;

import java.util.List;

public interface GlucoseLevelService {
    GlucoseLevel createGlucoseLevel(CreateGlucoseLevelRequest glucoseLevelRequest, String profileId);
    List<GlucoseLevel> getAllGlucoseLevels();
}
