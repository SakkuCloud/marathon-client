package mesosphere.marathon.client.model.v2.pod.status;

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
public class ContainerEndpointStatus {
    private String name;
    private Integer allocatedHostPort;
    private Boolean healthy;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
