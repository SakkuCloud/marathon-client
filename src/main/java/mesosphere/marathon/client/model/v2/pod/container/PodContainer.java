package mesosphere.marathon.client.model.v2.pod.container;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.pod.linux.LinuxInfo;
import mesosphere.marathon.client.model.v2.app.artifact.Artifact;
import mesosphere.marathon.client.model.v2.app.check.Check;
import mesosphere.marathon.client.model.v2.app.health.HealthCheck;
import mesosphere.marathon.client.model.v2.app.network.Endpoint;
import mesosphere.marathon.client.model.v2.app.resources.Resources;
import mesosphere.marathon.client.model.v2.pod.volumes.VolumeMount;

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
public class PodContainer {
    private String name;
    private List<Artifact> artifacts;
    private Check check;
    private List<Endpoint> endpoints;
    private Map<String, Object> environment;
    private Map<String, Object> labels;
    private MesosExec exec;
    private HealthCheck healthCheck;
    private Image image;
    private Lifecycle lifecycle;
    private LinuxInfo linuxInfo;
    private Resources resources;
    private Boolean tty;
    private String user;
    private List<VolumeMount> volumeMounts;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
