package mesosphere.marathon.client.model.v2.pod.container;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.container.PullConfig;

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
public class Image {
    private String id;
    private Type kind;
    private Boolean forcePull;
    private PullConfig pullConfig;
    private Map<String, Object> labels;


    public enum Type {
        DOCKER
    }


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
