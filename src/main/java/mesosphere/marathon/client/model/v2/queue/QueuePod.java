package mesosphere.marathon.client.model.v2.queue;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.pod.Pod;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueuePod {
    private Pod pod;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
