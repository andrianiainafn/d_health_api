package health.d_health_api.services;

import health.d_health_api.dto.requests.CreateBloodPressureRequest;
import health.d_health_api.model.BloodPressure;

public interface BloodPressureService {
    BloodPressure createBloodPressure(CreateBloodPressureRequest bloodPressureRequest, String profileId);
}
