package mesosphere.marathon.client.model.v2.app.container;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.common.Parameter;

import java.util.Collection;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Docker {
	private String image;
	private Network network;
	private boolean forcePullImage;
	private Collection<Port> portMappings;
	private Collection<Parameter> parameters;
	private boolean privileged;
	private PullConfig pullConfig;
	private Credential credential;


	public enum Network {
		BRIDGE, HOST, NONE, USER;
	}


	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
