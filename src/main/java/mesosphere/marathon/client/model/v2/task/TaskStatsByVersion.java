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
public class TaskStatsByVersion {
    private Stats startedAfterLastScaling;
    private Stats totalSummary;
    private Stats withLatestConfig;
    private Stats withOutdatedConfig;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
