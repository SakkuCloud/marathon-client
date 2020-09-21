package mesosphere.marathon.client.model.v2.queue;

import lombok.*;
import mesosphere.client.common.ModelUtils;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeclinedOfferStep {
    private String reason;
    private Integer declined;
    private Integer processed;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
