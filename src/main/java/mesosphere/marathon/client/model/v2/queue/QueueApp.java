package mesosphere.marathon.client.model.v2.queue;

import lombok.*;
import lombok.experimental.SuperBuilder;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.VersionedApp;

import java.util.Date;
import java.util.List;

/**
 * @author AliTM
 */

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueueApp extends QueueItem {
    private VersionedApp app;
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
