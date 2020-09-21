package mesosphere.marathon.client.model.v2.app;


import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VersionedApp extends App {
	private String version;


	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
