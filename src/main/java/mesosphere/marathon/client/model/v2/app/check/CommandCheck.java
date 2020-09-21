package mesosphere.marathon.client.model.v2.app.check;

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
public class CommandCheck {
    private MesosCommand command;

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
