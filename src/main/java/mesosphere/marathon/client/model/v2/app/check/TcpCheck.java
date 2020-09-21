package mesosphere.marathon.client.model.v2.app.check;

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
public class TcpCheck {
    private Integer port;
    private Integer portIndex;
    private String endpoint;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
