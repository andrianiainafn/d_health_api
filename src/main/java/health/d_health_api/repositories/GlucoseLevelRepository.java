package health.d_health_api.repositories;

import health.d_health_api.model.BloodPressure;
import health.d_health_api.model.GlucoseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
public interface GlucoseLevelRepository extends JpaRepository<GlucoseLevel,String> {
    List<GlucoseLevel> findAllByGlucoseLevelIdIsIn(Collection<String> glucoseLevelIds);
}
