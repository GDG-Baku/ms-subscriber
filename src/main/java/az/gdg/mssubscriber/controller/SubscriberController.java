package az.gdg.mssubscriber.controller;

import az.gdg.mssubscriber.model.SubscriberRequest;
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
    public void createSubscriber(@RequestBody SubscriberRequest subscriberRequest){
        subscriberService.createSubscriber(subscriberRequest);
    }

    @ApiOperation("delete subscriber by id")
    @DeleteMapping("/{id}")
    public void deleteSubscriber(@PathVariable("id") int id){
        subscriberService.deleteSubscriber(id);
    }
}
