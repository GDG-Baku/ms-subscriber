package az.gdg.mssubscriber.model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberRequest {
    private String email;
}
