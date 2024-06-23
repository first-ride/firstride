package firstride.ridems.repository;

import firstride.ridems.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepo extends JpaRepository<RideEntity,Long> {
}
