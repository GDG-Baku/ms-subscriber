package az.gdg.mssubscriber.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberDTO {
    private Integer id;
    private String email;
}
