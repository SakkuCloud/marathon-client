package mesosphere.marathon.client.model.v2.pod.volumes;

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
public class AppHostVolume extends AppVolume {
    private String hostPath;
    private ReadMode mode;
}
