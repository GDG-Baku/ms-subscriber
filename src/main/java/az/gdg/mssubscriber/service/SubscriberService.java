package az.gdg.mssubscriber.service;

import az.gdg.mssubscriber.model.dto.SubscriberDTO;

import java.util.List;

public interface SubscriberService {

    List<SubscriberDTO> getAllSubscribers();

    void createSubscriber(SubscriberDTO SubscriberDTO);

    void deleteSubscriber(String email);

}
