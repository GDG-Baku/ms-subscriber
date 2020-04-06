package az.gdg.mssubscriber.controller;

import az.gdg.mssubscriber.model.dto.SubscriberDTO;
import az.gdg.mssubscriber.service.SubscriberService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/subscriber")
@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class SubscriberController {

    private static final Logger logger = LoggerFactory.getLogger(SubscriberController.class);
    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @ApiOperation("get all subscribers")
    @GetMapping
    public List<SubscriberDTO> getAllSubscribers() {
        logger.debug("Get all subscribers");
        return subscriberService.getAllSubscribers();
    }

    @ApiOperation("create subscriber")
    @PostMapping
    public void createSubscriber(@RequestBody @Valid SubscriberDTO subscriberDTO) {
        logger.debug("Create subscriber start");
        subscriberService.createSubscriber(subscriberDTO);
        logger.debug("Create subscriber end");
    }

    @ApiOperation("delete subscriber by email")
    @DeleteMapping()
    public void deleteSubscriber(@RequestBody @Valid SubscriberDTO subscriberDTO) {
        logger.debug("Delete subscriber start");
        subscriberService.deleteSubscriber(subscriberDTO.getEmail());
        logger.debug("Delete subscriber end");
    }
}
