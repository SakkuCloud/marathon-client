package mesosphere.marathon.client.model.v2.task;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.common.IpProtocol;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IpAddr {
    private String ipAddress;
    private IpProtocol protocol;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
