package az.gdg.mssubscriber.service.impl;

import az.gdg.mssubscriber.exception.SubscriberAlreadyExistException;
import az.gdg.mssubscriber.mapper.SubscriberMapper;
import az.gdg.mssubscriber.model.dto.MailDTO;
import az.gdg.mssubscriber.model.dto.SubscriberDTO;
import az.gdg.mssubscriber.repository.SubscriberRepository;
import az.gdg.mssubscriber.repository.entitiy.SubscriberEntity;
import az.gdg.mssubscriber.service.MailService;
import az.gdg.mssubscriber.service.SubscriberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    private static final Logger logger = LoggerFactory.getLogger(SubscriberServiceImpl.class);
    private final SubscriberRepository subscriberRepository;
    private final MailService mailService;

    public SubscriberServiceImpl(SubscriberRepository subscriberRepository, MailService mailService) {
        this.subscriberRepository = subscriberRepository;
        this.mailService = mailService;
    }

    @Override
    public List<SubscriberDTO> getAllSubscribers() {
        logger.info("ActionLog.getAllSubscribers.start");
        List<SubscriberEntity> subscribers = subscriberRepository.findAll();
        return SubscriberMapper.INSTANCE.entityListToDtoList(subscribers);
    }

    @Override
    public void createSubscriber(SubscriberDTO subscriberDTO) {
        logger.info("ActionLog.createSubscriber.start");
        SubscriberEntity subscriber = SubscriberMapper.INSTANCE.dtoToEntity(subscriberDTO);
        if (subscriberRepository.findSubscriberByEmail(subscriberDTO.getEmail()) != null) {
            throw new SubscriberAlreadyExistException("Subscriber already exists");
        }
        subscriberRepository.save(subscriber);
        MailDTO mailDTO = MailDTO.builder()
                .to(Collections.singletonList(subscriberDTO.getEmail()))
                .subject("You have been subscribed")
                .body("Congrats! You have been subscribed successfully")
                .build();
        mailService.sendToQueue(mailDTO);
        logger.info("ActionLog.createSubscriber.success");
    }


    @Override
    public void deleteSubscriber(String email) {
        logger.info("ActionLog.deleteSubscriber.start");
        SubscriberEntity subscriberEntity = subscriberRepository.findSubscriberByEmail(email);
        subscriberRepository.delete(subscriberEntity);
        logger.info("ActionLog.deleteSubscriber.end");
    }
}
