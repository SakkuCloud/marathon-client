package mesosphere.marathon.client.model.v2.pod;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.UnreachableStrategy;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PodSchedulingPolicy {
    private PodSchedulingBackoffStrategy backoff;
//    private KillSelection killSelection;
    private PodPlacementPolicy placement;
    private UnreachableStrategy unreachableStrategy;
    private PodUpgradeStrategy upgrade;

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
