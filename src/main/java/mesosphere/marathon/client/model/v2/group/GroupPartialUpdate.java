package mesosphere.marathon.client.model.v2.group;

import lombok.*;
import lombok.experimental.SuperBuilder;
import mesosphere.client.common.ModelUtils;

/**
 * @author AliTM
 */

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GroupPartialUpdate {
    private Boolean enforceRole;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
