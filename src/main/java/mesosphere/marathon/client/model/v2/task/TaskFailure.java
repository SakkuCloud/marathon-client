package mesosphere.marathon.client.model.v2.task;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskFailure {
	private String appId;
	private String host;
	private String message;
	private String state;
	private String taskId;
	private String timestamp;
	private String version;
	private String slaveId;


	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}

}
