package mesosphere.marathon.client.model.v2.pod.status;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.resources.Resources;

import java.util.Date;
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
public class ContainerStatus {
    private String name;
    private String containerId;
    private String message;
    private String status;
    private List<StatusCondition> conditions;
    private List<ContainerEndpointStatus> endpoints;
    private Date statusSince;
    private Date lastChanged;
    private Date lastUpdated;
    private Resources resources;
    private ContainerTerminationState termination;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
