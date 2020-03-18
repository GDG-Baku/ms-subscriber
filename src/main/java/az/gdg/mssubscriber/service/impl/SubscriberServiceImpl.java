package az.gdg.mssubscriber.service.impl;

import az.gdg.mssubscriber.exception.SubscriberAlreadyExistException;
import az.gdg.mssubscriber.mapper.SubscriberMapper;
import az.gdg.mssubscriber.model.dto.SubscriberDTO;
import az.gdg.mssubscriber.model.entitiy.SubscriberEntity;
import az.gdg.mssubscriber.repository.SubscriberRepository;
import az.gdg.mssubscriber.service.SubscriberService;
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
        List<SubscriberEntity> subscribers = subscriberRepository.findAll();
        return SubscriberMapper.INSTANCE.entityListToDtoList(subscribers);
    }

    @Override
    public void createSubscriber(SubscriberDTO subscriberDTO) {
        SubscriberEntity subscriber = new SubscriberEntity();
        if(subscriberRepository.findSubscriberByEmail(subscriberDTO.getEmail()) != null){
            throw new SubscriberAlreadyExistException("Subscriber Already Exist");
        }

        subscriber.setEmail(subscriberDTO.getEmail());
        subscriberRepository.save(subscriber);
    }


    @Override
    public void deleteSubscriber(String email) {
        SubscriberEntity subscriberEntity = subscriberRepository.findSubscriberByEmail(email);
        subscriberRepository.delete(subscriberEntity);
    }
}
