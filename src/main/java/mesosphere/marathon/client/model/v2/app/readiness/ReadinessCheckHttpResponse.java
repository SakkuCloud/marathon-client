package mesosphere.marathon.client.model.v2.app.readiness;

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
public class ReadinessCheckHttpResponse {
    private String body;
    private String contentType;
    private Integer status;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
