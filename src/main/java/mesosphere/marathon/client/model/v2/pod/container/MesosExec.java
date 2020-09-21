package mesosphere.marathon.client.model.v2.pod.container;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.app.check.MesosCommand;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MesosExec {
    private MesosCommand command;
    private Boolean overrideEntrypoint;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
