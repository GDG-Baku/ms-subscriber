package az.gdg.mssubscriber.mapper;

import az.gdg.mssubscriber.model.dto.SubscriberDTO;
import az.gdg.mssubscriber.model.entitiy.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriberMapper {

    SubscriberMapper INSTANCE = Mappers.getMapper( SubscriberMapper.class );

    public SubscriberDTO complaintToDTO(Subscriber complaint);

    public Subscriber DtoToComplaint(SubscriberDTO complaintDTO);

    public List<SubscriberDTO> complaintListToDTO(List<Subscriber> complaint);
}
