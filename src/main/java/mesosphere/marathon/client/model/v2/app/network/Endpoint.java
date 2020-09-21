package mesosphere.marathon.client.model.v2.app.network;

import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.List;
import java.util.Map;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endpoint {
    private String name;
    private Integer containerPort;
    private Integer hostPort;
    private Map<String, Object> labels;
    private List<String> networkNames;
    private List<String> protocol;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
