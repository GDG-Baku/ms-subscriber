package az.gdg.mssubscriber.service.impl;

import az.gdg.mssubscriber.mapper.SubscriberMapper;
import az.gdg.mssubscriber.model.SubscriberRequest;
import az.gdg.mssubscriber.model.dto.SubscriberDTO;
import az.gdg.mssubscriber.model.entitiy.Subscriber;
import az.gdg.mssubscriber.repository.SubscriberRepository;
import az.gdg.mssubscriber.service.SubscriberService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberRepository subscriberRepository;

    public SubscriberServiceImpl(SubscriberRepository subscriberRepository){
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public List<SubscriberDTO> getAllSubscribers() {
        Iterable<Subscriber> complaints = subscriberRepository.findAll();
        return SubscriberMapper.INSTANCE.complaintListToDTO(IterableUtils.toList(complaints));
    }

    @Override
    public void createSubscriber(SubscriberRequest subscriberRequest) {
        Subscriber complaint = new Subscriber();
        complaint.setEmail(subscriberRequest.getEmail());
        subscriberRepository.save(complaint);
    }


    @Override
    public void deleteSubscriber(int id) {
        subscriberRepository.deleteById(id);
    }
}
