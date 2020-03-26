package az.gdg.mssubscriber.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import az.gdg.mssubscriber.model.dto.SubscriberDTO;
import az.gdg.mssubscriber.service.SubscriberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/subscriber")
@RestController
public class SubscriberController {

    private static final Logger logger = LoggerFactory.getLogger(SubscriberController.class);
    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService){
        this.subscriberService = subscriberService;
    }

    @ApiOperation("get all subscribers")
    @GetMapping
    public List<SubscriberDTO> getAllSubscribers(){
        logger.debug("Get all subscribers");
        return subscriberService.getAllSubscribers();
    }

    @ApiOperation("create subscriber")
    @PostMapping
    public void createSubscriber(@RequestBody SubscriberDTO subscriberDTO){
        logger.debug("Create subscriber start");
        subscriberService.createSubscriber(subscriberDTO);
        logger.debug("Create subscriber end");
    }

    @ApiOperation("delete subscriber by email")
    @DeleteMapping()
    public void deleteSubscriber(@RequestBody SubscriberDTO subscriberDTO){
        logger.debug("Delete subscriber start");
        subscriberService.deleteSubscriber(subscriberDTO.getEmail());
        logger.debug("Delete subscriber end");
    }
}
