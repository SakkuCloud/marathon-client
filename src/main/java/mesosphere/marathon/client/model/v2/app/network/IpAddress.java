package mesosphere.marathon.client.model.v2.app.network;

import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IpAddress {
    private IpDiscovery discovery;
    private List<String> groups;
    private Map<String, Object> labels;
    private String networkName;

    public void addGroup(final String group) {
        if (this.groups == null) this.groups = new ArrayList<>(5);
        this.groups.add(group);
    }

    public void addLabel(final String key, final Object value) {
        if (key != null && key.trim().length() > 0 && value != null) {
            if (this.labels == null) {
                this.labels = new HashMap<>(5);
            }

            this.labels.put(key, value);
        }
    }


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
