package health.d_health_api.services;


import health.d_health_api.dto.requests.CreateHartRateRequest;

public interface HartRateService {
    public void createHartRate(CreateHartRateRequest hartRateRequest, String token);
}
