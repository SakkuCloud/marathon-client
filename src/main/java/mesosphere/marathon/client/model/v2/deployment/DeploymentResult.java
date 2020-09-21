package mesosphere.marathon.client.model.v2.deployment;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeploymentResult {
	private String deploymentId;
	private String version;


	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
