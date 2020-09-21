package mesosphere.marathon.client.model.v2.queue;

import java.util.List;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Queue {
    private List<QueueItem> queue;

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
