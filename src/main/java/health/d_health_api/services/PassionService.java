package health.d_health_api.services;


import health.d_health_api.dto.requests.CreatePassionRequestDto;

public interface PassionService {
    public void createPassion(CreatePassionRequestDto createPassionRequestDto);
}
