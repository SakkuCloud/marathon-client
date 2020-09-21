package mesosphere.marathon.client.model.v2.app.container;

import java.util.List;
import java.util.Map;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.network.NetworkProtocol;

/**
 * @author AliTM
 * app.appContainer.ContainerPortMapping
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Port {
    private Integer hostPort;
    @Builder.Default
    private Integer containerPort = 0;
    @Builder.Default
    private Integer servicePort = 0;
    @Builder.Default
    private NetworkProtocol protocol = NetworkProtocol.tcp;
    private String name;
    private List<String> networkNames;
    private Map<String, String> labels;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
