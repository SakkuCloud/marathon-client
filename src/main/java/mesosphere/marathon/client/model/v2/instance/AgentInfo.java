package mesosphere.marathon.client.model.v2.instance;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.instance.offer.AgentAttribute;

import java.util.List;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgentInfo {
    private String agentId;
    private List<AgentAttribute> attributes;
    private String host;
    private String region;
    private String zone;

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
