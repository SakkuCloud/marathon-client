package mesosphere.marathon.client.model.v2.pod.container;

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
public class Lifecycle {
    private Integer killGracePeriodSeconds;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
