package mesosphere.marathon.client.model.v2.info;

import lombok.*;
import mesosphere.client.common.ModelUtils;

/**
 * @author AliTM
 */

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaderInfo {
    private String leader;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
