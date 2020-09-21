package mesosphere.marathon.client.model.v2.app.health;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.common.IpProtocol;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppHealthCheck {
    private AppCommandCheck command;
    @Builder.Default
    private Integer delaySeconds = 15;
    @Builder.Default
    private Integer gracePeriodSeconds = 300;
    @Builder.Default
    private Integer intervalSeconds = 60;
    @Builder.Default
    private Integer maxConsecutiveFailures = 3;
    private Integer portIndex;
    private Integer port;
    @Builder.Default
    private Integer timeoutSeconds = 20;
    private boolean ignoreHttp1xx;
    private String path;
    @Builder.Default
    private AppHealthCheckProtocol protocol = AppHealthCheckProtocol.HTTP;
    @Builder.Default
    private IpProtocol ipProtocol = IpProtocol.IPv4;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
