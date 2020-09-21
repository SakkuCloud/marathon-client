package mesosphere.marathon.client.model.v2.task;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.check.CheckStatus;
import mesosphere.marathon.client.model.v2.app.health.Health;
import mesosphere.marathon.client.model.v2.app.network.IpAddress;
import mesosphere.marathon.client.model.v2.pod.volumes.LocalVolumeId;

import java.util.List;
import java.util.Set;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String id;
    private String appId;
    private String host;
    private String region;
    private String zone;
    private String role;
    private String slaveId;
    private String stagedAt;
    private String startedAt;
    private MesosTaskState state;
    private Set<Integer> ports;
    private Set<Integer> servicePorts;
    private List<LocalVolumeId> localVolumes;
    private List<IpAddress> ipAddresses;
    private List<Health> healthCheckResults;
    private CheckStatus checkStatus;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
