package mesosphere.marathon.client.model.v2.app;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Residency {
    @Builder.Default
    private int relaunchEscalationTimeoutSeconds = 3600;
    @Builder.Default
    private TaskLostBehavior taskLostBehavior = TaskLostBehavior.WAIT_FOREVER;


    public enum TaskLostBehavior {
        WAIT_FOREVER, RELAUNCH_AFTER_TIMEOUT;
    }


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
