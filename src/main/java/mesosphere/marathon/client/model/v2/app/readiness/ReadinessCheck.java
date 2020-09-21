package mesosphere.marathon.client.model.v2.app.readiness;

import java.util.Set;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.common.HttpScheme;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadinessCheck {
	private String name;
	@Builder.Default
	private HttpScheme protocol = HttpScheme.HTTP;
	@Builder.Default
	private String path = "/";
	@Builder.Default
	private String portName = "http-api";
	@Builder.Default
	private int intervalSeconds = 30;
	@Builder.Default
	private int timeoutSeconds = 10;
	private Set<Integer> httpStatusCodesForReady;
	private boolean preserveLastResponse;


	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
