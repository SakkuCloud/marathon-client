package mesosphere.marathon.client.model.v2.app;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.VersionedApp;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppInfoList {
	private List<AppInfo> apps;


	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
