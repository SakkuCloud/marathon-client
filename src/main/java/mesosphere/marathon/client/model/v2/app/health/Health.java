package mesosphere.marathon.client.model.v2.app.health;

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
public class Health {
    private Boolean alive;
    private Integer consecutiveFailures;
    private String instanceId;
    private String firstSuccess;
    private String lastSuccess;
    private String lastFailure;
    private String lastFailureCause;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
