package az.gdg.mssubscriber.service;

import az.gdg.mssubscriber.model.dto.SubscriberDTO;

import java.util.List;

public interface SubscriberService {

    List<SubscriberDTO> getAllSubscribers();

    void createSubscriber(SubscriberDTO subscriberDTO);

    void deleteSubscriber(String token);

}
