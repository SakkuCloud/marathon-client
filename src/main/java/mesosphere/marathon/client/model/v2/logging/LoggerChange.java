package mesosphere.marathon.client.model.v2.logging;

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
public class LoggerChange {
    private Integer durationSeconds;
    private LoggerLevel level;
    private Integer logger;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
