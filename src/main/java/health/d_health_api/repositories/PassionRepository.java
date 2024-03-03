package health.d_health_api.repositories;

import health.d_health_api.model.Passion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface PassionRepository extends JpaRepository<Passion,Long> {
    Passion findPassionByEmail(String email);
    Passion findByPassionId(String passionId);
}
