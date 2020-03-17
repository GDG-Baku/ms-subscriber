package az.gdg.mssubscriber.repository;

import az.gdg.mssubscriber.model.entitiy.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Integer>{

}

