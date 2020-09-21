package mesosphere.marathon.client.model.v2.pod.linux;

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
public class Seccomp {
    private String profileName;
    private boolean unconfined;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
