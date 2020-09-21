package mesosphere.marathon.client.model.v2.deployment;

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
public class DeploymentPlan {
    private String id;
    private List<DeploymentStep> steps;
    private String version;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
