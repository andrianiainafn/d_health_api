package health.d_health_api.serviceImpls;

import health.d_health_api.dto.requests.CreateGlucoseLevelRequest;
import health.d_health_api.services.GlucoseLevelService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GlucoseLevelServiceImpl implements GlucoseLevelService {
    @Override
    public void createGlucoseLevel(CreateGlucoseLevelRequest glucoseLevelRequest, String token) {

    }
}
