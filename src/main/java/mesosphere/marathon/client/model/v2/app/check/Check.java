package mesosphere.marathon.client.model.v2.app.check;

import lombok.*;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Check {
    @Builder.Default
    private Integer delaySeconds = 15;
    @Builder.Default
    private Integer intervalSeconds = 60;
    @Builder.Default
    private Integer timeoutSeconds = 20;
    private CommandCheck exec;
    private HttpCheck http;
    private TcpCheck tcp;

}
