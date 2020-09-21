package mesosphere.marathon.client.model.v2.eventSubscriptions;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventSubscriptionRegister {
    private String callbackUrl;
    private String clientIp;
    private String eventType;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
