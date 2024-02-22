package health.d_health_api.services;


import health.d_health_api.dto.requests.CreatePassionRequestDto;
import health.d_health_api.model.Passion;

public interface PassionService {
    Passion loadPassionByEmail(String email);
}
