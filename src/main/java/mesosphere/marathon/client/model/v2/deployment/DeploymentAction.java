package mesosphere.marathon.client.model.v2.deployment;

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
public class DeploymentAction {
    private ActionName action;
    private String app;
    private String pod;


    public static enum ActionName {
        StartApplication, StopApplication, ScaleApplication, RestartApplication, StartPod, StopPod, ScalePod, RestartPod, ResolveArtifacts;
    }


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
