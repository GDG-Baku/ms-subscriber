package az.gdg.mssubscriber.repository;

import az.gdg.mssubscriber.repository.entity.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Long> {
    SubscriberEntity findSubscriberByEmail(String email);

}

