package springcofing.client.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import springcofing.client.entities.Subscription;

public interface SubRepo extends JpaRepository<Subscription, Long > {


}
