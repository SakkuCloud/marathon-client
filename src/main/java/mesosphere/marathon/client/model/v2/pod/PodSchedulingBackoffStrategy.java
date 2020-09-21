package mesosphere.marathon.client.model.v2.pod;

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
public class PodSchedulingBackoffStrategy {
    @Builder.Default
    private Integer backoff = 1;
    @Builder.Default
    private Double backoffFactor = 1.15d;
    @Builder.Default
    private Integer maxLaunchDelay = 300;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
