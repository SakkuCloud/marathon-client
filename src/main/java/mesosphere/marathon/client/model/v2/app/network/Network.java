package mesosphere.marathon.client.model.v2.app.network;

import java.util.HashMap;
import java.util.Map;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Network {
	public String name;
	@Builder.Default
	public NetworkMode mode = NetworkMode.CONTAINER;
	@Builder.Default
	private Map<String, String> labels = new HashMap<>();


	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
