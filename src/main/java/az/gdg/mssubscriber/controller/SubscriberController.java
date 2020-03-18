package az.gdg.mssubscriber.controller;

import az.gdg.mssubscriber.model.dto.SubscriberDTO;
import az.gdg.mssubscriber.service.SubscriberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/subscriber")
@RestController
public class SubscriberController {

    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService){
        this.subscriberService = subscriberService;
    }

    @ApiOperation("get all subscribers")
    @GetMapping
    public List<SubscriberDTO> getAllSubscribers(){
        return subscriberService.getAllSubscribers();
    }

    @ApiOperation("create subscriber")
    @PostMapping
    public void createSubscriber(@RequestBody SubscriberDTO subscriberDTO){
        subscriberService.createSubscriber(subscriberDTO);
    }

    @ApiOperation("delete subscriber by email")
    @DeleteMapping()
    public void deleteSubscriber(@RequestBody SubscriberDTO subscriberDTO){
        subscriberService.deleteSubscriber(subscriberDTO.getEmail());
    }
}
