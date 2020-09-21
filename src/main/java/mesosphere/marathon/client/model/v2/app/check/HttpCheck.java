package mesosphere.marathon.client.model.v2.app.check;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.common.HttpScheme;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HttpCheck {
    private String path;
    private Integer port;
    private Integer portIndex;
    @Builder.Default
    private HttpScheme scheme = HttpScheme.HTTP;
    private String endpoint;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
