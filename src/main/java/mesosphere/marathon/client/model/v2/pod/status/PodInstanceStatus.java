package mesosphere.marathon.client.model.v2.pod.status;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.resources.Resources;
import mesosphere.marathon.client.model.v2.pod.volumes.LocalVolumeId;

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
public class PodInstanceStatus {
    private String id;
    private String message;
    private String role;
    private String agentHostname;
    private String agentId;
    private String agentRegion;
    private String agentZone;
    private PodInstanceState status;
    private Date statusSince;
    private Date lastChanged;
    private Date lastUpdated;
    private List<LocalVolumeId> localVolumes;
    private List<String> containers;
    private List<StatusCondition> conditions;
    private List<NetworkStatus> networks;
    private Resources resources;
    private String specReference;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
