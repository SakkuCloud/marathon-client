package mesosphere.marathon.client.model.v2.pod;

import lombok.*;
import lombok.experimental.SuperBuilder;
import mesosphere.client.common.ModelUtils;

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
public class FixedPodScalingPolicy extends PodScalingPolicy {
    @Builder.Default
    private Integer instances = 1;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
