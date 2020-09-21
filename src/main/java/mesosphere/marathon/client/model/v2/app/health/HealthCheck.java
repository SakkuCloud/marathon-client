package mesosphere.marathon.client.model.v2.app.health;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.check.CommandCheck;
import mesosphere.marathon.client.model.v2.app.check.HttpCheck;
import mesosphere.marathon.client.model.v2.app.check.TcpCheck;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthCheck {
    @Builder.Default
    private Integer delaySeconds = 15;
    @Builder.Default
    private Integer gracePeriodSeconds = 300;
    @Builder.Default
    private Integer intervalSeconds = 60;
    @Builder.Default
    private Integer maxConsecutiveFailures = 3;
    @Builder.Default
    private Integer timeoutSeconds = 20;
    private CommandCheck exec;
    private TcpCheck tcp;
    private HttpCheck http;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
