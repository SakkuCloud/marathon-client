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
public class ContainerTerminationState {
    private Integer exitCode;
    private String message;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
