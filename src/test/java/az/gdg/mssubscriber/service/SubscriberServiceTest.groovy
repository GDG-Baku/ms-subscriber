import az.gdg.mssubscriber.exception.SubscriberAlreadyExistException
import az.gdg.mssubscriber.mapper.SubscriberMapper
import az.gdg.mssubscriber.model.dto.SubscriberDTO
import az.gdg.mssubscriber.repository.SubscriberRepository
import az.gdg.mssubscriber.repository.entity.SubscriberEntity
import az.gdg.mssubscriber.service.impl.SubscriberServiceImpl
import spock.lang.Specification
import spock.lang.Title

@Title("Testing for Subscriber Service")
class SubscriberServiceTest extends Specification {
    
    SubscriberRepository subscriberRepository
    SubscriberServiceImpl subscriberServiceImpl
    
    def setup() {
        subscriberRepository = Mock()
        subscriberServiceImpl = new SubscriberServiceImpl(subscriberRepository)
    }
    
    def "should use the repository to fetch all subscribers"() {
        given:
            def subscriber1 = new SubscriberEntity(id: 1, email: "alihsoff@gmail.com")
            def subscriber2 = new SubscriberEntity(id: 2, email: "huseynov_ali@outlook.com")
            def subscriber3 = new SubscriberEntity(id: 3, email: "ehuseynov@std.beu.edu.az")
        
        when:
            def res = subscriberServiceImpl.getAllSubscribers()
        
        then: "get all subscribers from repository"
            1 * subscriberRepository.findAll() >> [subscriber1, subscriber2, subscriber3]
            res.size() == 3
    }
    
    def "should create subscriber and not throw SubscriberAlreadyExistException"() {
        given:
            def subscriberDTO = new SubscriberDTO("alihsoff@gmail.com")
            def subscriber = SubscriberMapper.INSTANCE.dtoToEntity(subscriberDTO)
        
        when:
            subscriberServiceImpl.createSubscriber(subscriberDTO)
        
        then:
            1 * subscriberRepository.save(subscriber)
            notThrown(SubscriberAlreadyExistException)
    }
    
    def "should throw SubscriberAlreadyExistException"() {
        given:
            def subscriberDTO = new SubscriberDTO("alihsoff@gmail.com")
            def subscriber = SubscriberMapper.INSTANCE.dtoToEntity(subscriberDTO)
            1 * subscriberRepository.findSubscriberByEmail(subscriberDTO.getEmail()) >> subscriber
        
        when:
            subscriberServiceImpl.createSubscriber(subscriberDTO)
        
        then:
            thrown(SubscriberAlreadyExistException)
    }
    
    def "should delete subscriber by email"() {
        given:
            def email = "alihsoff@gmail.com"
            def subscriber = new SubscriberEntity(id: 1, email: email)
        
        
        when:
            subscriberServiceImpl.deleteSubscriber(email)
        
        then:
            1 * subscriberRepository.findSubscriberByEmail(email) >> subscriber
            1 * subscriberRepository.delete(subscriber)
        
    }
}