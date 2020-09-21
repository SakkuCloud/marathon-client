package mesosphere.marathon.client.model.v2.logging;

import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.List;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loggers {
    private List<LoggerChange> loggers;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
