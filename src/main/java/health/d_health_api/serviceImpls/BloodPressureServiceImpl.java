package health.d_health_api.serviceImpls;

import health.d_health_api.dto.requests.CreateBloodPressureRequest;
import health.d_health_api.services.BloodPressureService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BloodPressureServiceImpl implements BloodPressureService {
    @Override
    public void createBloodPressure(CreateBloodPressureRequest bloodPressureRequest, String token) {

    }
}
