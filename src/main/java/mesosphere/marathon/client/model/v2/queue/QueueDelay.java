package mesosphere.marathon.client.model.v2.queue;

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
public class QueueDelay {
    private Boolean overdue;
    private Integer timeLeftSeconds;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
