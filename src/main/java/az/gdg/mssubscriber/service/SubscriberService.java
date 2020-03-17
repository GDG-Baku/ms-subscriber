package az.gdg.mssubscriber.service;

import az.gdg.mssubscriber.model.SubscriberRequest;
import az.gdg.mssubscriber.model.dto.SubscriberDTO;

import java.util.List;

public interface SubscriberService {

    public List<SubscriberDTO> getAllSubscribers();

    public void createSubscriber(SubscriberRequest subscriberRequest);

    public void deleteSubscriber(int id);

}
