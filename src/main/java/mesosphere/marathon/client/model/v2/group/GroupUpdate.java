package mesosphere.marathon.client.model.v2.group;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.App;

import java.util.Collection;

/**
 * @author AliTM
 */

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupUpdate extends GroupPartialUpdate {
    private String id;
    private Integer scaleBy;
    private Collection<App> apps;
    private Collection<GroupUpdate> groups;
    private Collection<String> dependencies;
    private String version;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
