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
public class LocalVolumeId {
    private String containerPath;
    private String uuid;
    private String persistenceId;
    private String runSpecId;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
