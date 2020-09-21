package mesosphere.marathon.client.model.v2.metrics;

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
public class Gauge {
    private Double value;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
