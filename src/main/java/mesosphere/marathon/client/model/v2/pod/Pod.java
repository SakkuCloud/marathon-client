package mesosphere.marathon.client.model.v2.pod;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.pod.linux.LinuxInfo;
import mesosphere.marathon.client.model.v2.app.network.Network;
import mesosphere.marathon.client.model.v2.app.resources.ExecutorResources;
import mesosphere.marathon.client.model.v2.app.secrets.SecretDef;
import mesosphere.marathon.client.model.v2.pod.container.PodContainer;
import mesosphere.marathon.client.model.v2.pod.volumes.PodVolume;

import java.util.List;
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
public class Pod {
    private String id;
    private String user;
    private String role;
    private List<PodContainer> containers;
    private List<PodVolume> volumes;
    private String version;
    private Map<String, String> environment;
    private Map<String, String> labels;
    private ExecutorResources resources;
    private LinuxInfo linuxInfo;
    private List<Network> networks;
    private PodScalingPolicy scaling;
    private PodSchedulingPolicy scheduling;
    private Map<String, SecretDef> secrets;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
