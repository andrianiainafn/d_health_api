package health.d_health_api.services;

import health.d_health_api.dto.requests.CreateGlucoseLevelRequest;

public interface GlucoseLevelService {
    public void createGlucoseLevel(CreateGlucoseLevelRequest glucoseLevelRequest, String token);
}
