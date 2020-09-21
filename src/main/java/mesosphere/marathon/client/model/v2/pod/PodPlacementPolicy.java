package mesosphere.marathon.client.model.v2.pod;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.constraints.Constraint;

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
public class PodPlacementPolicy {
    private List<String> acceptedResourceRoles;
    private List<Constraint> constraints;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
