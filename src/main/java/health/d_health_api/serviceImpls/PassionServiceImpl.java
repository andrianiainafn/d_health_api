package health.d_health_api.serviceImpls;


import health.d_health_api.model.Passion;
import health.d_health_api.repositories.PassionRepository;
import health.d_health_api.services.PassionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PassionServiceImpl implements PassionService {
    private final PassionRepository passionRepository;

    public PassionServiceImpl(PassionRepository passionRepository) {
        this.passionRepository = passionRepository;
    }

    @Override
    public Passion loadPassionByEmail(String email) {
        return passionRepository.findPassionByEmail(email);
    }
}
