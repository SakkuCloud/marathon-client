package mesosphere.marathon.client.model.v2.group;

import java.util.Collection;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.pod.status.PodStatus;
import mesosphere.marathon.client.model.v2.app.AppInfo;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private String id;
    private String version;
    private Boolean enforceRole;
    private Collection<AppInfo> apps;
    private Collection<Group> groups;
    private Collection<String> dependencies;
    private Collection<PodStatus> pods;


    public Group(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
