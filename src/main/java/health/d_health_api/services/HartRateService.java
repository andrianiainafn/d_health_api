package health.d_health_api.services;


import health.d_health_api.dto.requests.CreateHartRateRequest;
import health.d_health_api.model.HartRate;

public interface HartRateService {
    HartRate createHartRate(CreateHartRateRequest hartRateRequest, String profileId);
}
