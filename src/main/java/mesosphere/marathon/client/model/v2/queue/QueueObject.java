package mesosphere.marathon.client.model.v2.queue;

import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.Date;
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
public class QueueObject {
    private Integer count;
    private String role;
    private QueueDelay delay;
    private List<UnusedOffer> lastUnusedOffers;
    private ProcessedOffersSummary processedOffersSummary;
    private Date since;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
