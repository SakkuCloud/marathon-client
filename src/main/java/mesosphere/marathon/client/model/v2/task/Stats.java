package mesosphere.marathon.client.model.v2.task;

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
public class Stats {
    private TaskStats stats;

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
