package mesosphere.marathon.client.model.v2.pod.volumes;

import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.List;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersistentVolumeInfo {
    private String profileName;
    private Integer size;
    private Integer maxSize;
    private PersistentVolumeType type;
    private List<String> constraints;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
