package mesosphere.marathon.client.model.v2.pod.volumes;

import lombok.*;
import lombok.experimental.SuperBuilder;
import mesosphere.client.common.ModelUtils;

/**
 * @author AliTM
 */

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class AppVolume {

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
