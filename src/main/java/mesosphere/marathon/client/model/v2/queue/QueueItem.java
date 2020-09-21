package mesosphere.marathon.client.model.v2.queue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import mesosphere.client.common.ModelUtils;

/**
 * @author AliTM
 */

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class QueueItem {

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
