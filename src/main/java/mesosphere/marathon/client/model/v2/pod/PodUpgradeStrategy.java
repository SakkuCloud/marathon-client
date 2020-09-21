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
public class PodUpgradeStrategy {
    @Builder.Default
    private Double maximumOverCapacity = 1d;
    @Builder.Default
    private Double minimumHealthCapacity = 1d;

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
