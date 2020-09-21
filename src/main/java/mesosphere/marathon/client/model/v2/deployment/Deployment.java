package mesosphere.marathon.client.model.v2.deployment;

import java.util.Collection;
import java.util.List;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.deployment.DeploymentAction;
import mesosphere.marathon.client.model.v2.deployment.DeploymentStep;


@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Deployment {
	private Collection<String> affectedApps;
	private Collection<String> affectedPods;
	private String id;
	private List<DeploymentStep> steps;
	private Collection<DeploymentAction> currentActions;
	private String version;
	private Integer currentStep;
	private Integer totalSteps;


	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
