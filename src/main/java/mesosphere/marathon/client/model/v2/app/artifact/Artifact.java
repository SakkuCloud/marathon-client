package mesosphere.marathon.client.model.v2.app.artifact;

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
public class Artifact {
    private String uri;
    private Boolean executable;
    private Boolean extract;
    private Boolean cache;
    private String destPath;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
