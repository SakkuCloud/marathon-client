package mesosphere.marathon.client.model.v2.app.network;

import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.Map;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IpDiscoveryPort {
    @Builder.Default
    private Integer number = 0;
    private String name;
    @Builder.Default
    private NetworkProtocol protocol = NetworkProtocol.tcp;
    private Map<String, Object> labels;


    public IpDiscoveryPort(int number, String name, NetworkProtocol protocol) {
        this.number = number;
        this.name = name;
        this.protocol = protocol;
    }


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
