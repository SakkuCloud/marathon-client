package mesosphere.marathon.client.model.v2.instance.offer;

import lombok.*;
import mesosphere.client.common.ModelUtils;

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
public class Offer {
    private String id;
    private String agentId;
    private List<AgentAttribute> attributes;
    private String hostname;
    private List<Resource> resources;


    @Data
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Resource {
        private String name;
        private List<NumberRange> ranges;
        private String role;
        private Integer scalar;
        private List<String> set;
    }


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
