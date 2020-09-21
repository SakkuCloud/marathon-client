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
public class TaskLifeTime {
    private Integer averageSeconds;
    private Integer medianSeconds;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
