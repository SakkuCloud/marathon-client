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
public class PodScalingPolicy {
    private String kind;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
