package mesosphere.marathon.client.model.v2.instance;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.UnreachableStrategy;

import java.util.Date;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instance {
    private String instanceId;
    private AgentInfo agentInfo;
    private String runSpecVersion;
    private State state;
    private UnreachableStrategy unreachableStrategy;


    @Data
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class State {
        private String condition;
        private String goal;
        private Boolean healthy;
        private Date since;
        private Date activeSince;
    }


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
