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
public class Histogram {
    private Integer count;
    private Integer max;
    private Integer min;
    private Integer mean;
    private Integer p50;
    private Integer p75;
    private Integer p95;
    private Integer p98;
    private Integer p99;
    private Integer p999;
    private Integer stddev;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
