package mesosphere.marathon.client.model.v2.pod.volumes;

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
@EqualsAndHashCode(callSuper = true)
public class PodEphemeralVolume extends PodVolume {
    private String name;
}
