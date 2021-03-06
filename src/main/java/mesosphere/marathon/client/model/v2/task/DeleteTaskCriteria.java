package mesosphere.marathon.client.model.v2.task;

import java.util.List;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteTaskCriteria {
    private List<String> ids;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
