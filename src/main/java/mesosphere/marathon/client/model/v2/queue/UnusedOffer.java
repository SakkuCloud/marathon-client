package mesosphere.marathon.client.model.v2.queue;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.instance.offer.Offer;

import java.util.List;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnusedOffer {
    private Offer offer;
    private List<String> reason;
    private String timestamp;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
