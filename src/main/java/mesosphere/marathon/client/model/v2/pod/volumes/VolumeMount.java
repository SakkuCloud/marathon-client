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
public class VolumeMount {
    private String name;
    private String mountPath;
    private Boolean readOnly;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
