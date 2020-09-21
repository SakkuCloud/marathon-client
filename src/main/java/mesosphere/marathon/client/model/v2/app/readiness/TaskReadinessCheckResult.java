package mesosphere.marathon.client.model.v2.app.readiness;

import lombok.*;
import mesosphere.client.common.ModelUtils;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskReadinessCheckResult {
    private String name;
    private Boolean ready;
    private String taskId;
    private ReadinessCheckHttpResponse lastResponse;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
