package mesosphere.marathon.client.model.v2.plugin;

import java.util.List;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PluginList {
    private List<Plugin> plugins;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
