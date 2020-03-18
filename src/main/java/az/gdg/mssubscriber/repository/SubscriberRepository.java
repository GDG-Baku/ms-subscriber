package az.gdg.mssubscriber.repository;

import az.gdg.mssubscriber.model.entitiy.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Integer> {
    public SubscriberEntity findSubscriberByEmail(String email);
}

