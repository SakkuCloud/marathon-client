package mesosphere.marathon.client.model.v2.app.container;

import java.util.Collection;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.pod.linux.LinuxInfo;
import mesosphere.marathon.client.model.v2.pod.volumes.AppVolume;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Container {
	@Builder.Default
	private EngineType type = EngineType.DOCKER;
	private Docker docker;
	private Collection<AppVolume> volumes;
	private Collection<Port> portMappings;
	private LinuxInfo linuxInfo;


	public enum EngineType {
		MESOS, DOCKER;
	}


	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
