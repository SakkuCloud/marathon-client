package mesosphere.marathon.client.model.v2.pod.volumes;

import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.Map;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExternalVolumeInfo {
    private String name;
    private String provider;
    private boolean shared;
    private Integer size;
    private Map<String, Object> options;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
