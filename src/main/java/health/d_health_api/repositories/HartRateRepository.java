package health.d_health_api.repositories;

import health.d_health_api.model.HartRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HartRateRepository extends JpaRepository<HartRate,Long> {
}
