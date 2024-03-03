package health.d_health_api.serviceImpls;

import health.d_health_api.dto.requests.CreateHartRateRequest;
import health.d_health_api.services.HartRateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HartRateServiceImpl implements HartRateService {
    @Override
    public void createHartRate(CreateHartRateRequest hartRateRequest, String token) {

    }
}
