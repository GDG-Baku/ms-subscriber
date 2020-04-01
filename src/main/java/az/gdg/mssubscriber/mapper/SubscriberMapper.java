package az.gdg.mssubscriber.mapper;

import az.gdg.mssubscriber.model.dto.SubscriberDTO;
import az.gdg.mssubscriber.repository.entitiy.SubscriberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriberMapper {

    SubscriberMapper INSTANCE = Mappers.getMapper(SubscriberMapper.class);

    SubscriberDTO entityToDTO(SubscriberEntity complaint);

    SubscriberEntity dtoToEntity(SubscriberDTO complaintDTO);

    List<SubscriberDTO> entityListToDtoList(List<SubscriberEntity> complaint);
}
