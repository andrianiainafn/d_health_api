package health.d_health_api.services;

import health.d_health_api.dto.requests.CreateBloodPressureRequest;

public interface BloodPressureService {
    public void createBloodPressure(CreateBloodPressureRequest bloodPressureRequest, String token);
}
