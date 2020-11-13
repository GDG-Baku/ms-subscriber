package az.gdg.mssubscriber.model.dto;

import az.gdg.mssubscriber.validation.subscriber.SubscriberConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SubscriberConstraint
public class SubscriberDTO {
    private String email;
}
