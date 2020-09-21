package mesosphere.marathon.client.model.v2.app;

import java.util.Collection;

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
public class VersionList {
    private Collection<String> versions;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
