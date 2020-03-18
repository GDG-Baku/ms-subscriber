package az.gdg.mssubscriber.mapper;

import az.gdg.mssubscriber.model.dto.SubscriberDTO;
import az.gdg.mssubscriber.model.entitiy.SubscriberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriberMapper {

    SubscriberMapper INSTANCE = Mappers.getMapper( SubscriberMapper.class );

    public SubscriberDTO entityToDTO(SubscriberEntity complaint);

    public SubscriberEntity dtoToEntity(SubscriberDTO complaintDTO);

    public List<SubscriberDTO> entityListToDtoList(List<SubscriberEntity> complaint);
}
