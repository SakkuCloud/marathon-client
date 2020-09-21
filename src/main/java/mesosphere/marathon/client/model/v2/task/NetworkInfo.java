package mesosphere.marathon.client.model.v2.task;

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
public class NetworkInfo {
    private String hostName;
    private List<Integer> hostPorts;
    private List<NetworkInfoIPAddress> ipAddresses;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
