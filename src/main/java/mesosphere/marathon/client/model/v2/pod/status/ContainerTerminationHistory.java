package mesosphere.marathon.client.model.v2.pod.status;

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
public class ContainerTerminationHistory {
    private String containerId;
    private String lastKnownState;
    private ContainerTerminationState termination;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
