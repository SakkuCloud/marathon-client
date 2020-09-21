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
public class ProcessedOffersSummary {
    private Integer unusedOffersCount;
    private Integer processedOffersCount;
    private Date lastUnusedOfferAt;
    private Date lastUsedOfferAt;
    private List<DeclinedOfferStep> rejectSummaryLastOffers;
    private List<DeclinedOfferStep> rejectSummaryLaunchAttempt;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
