package mesosphere.marathon.client.model.v2.metrics;

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
public class Metrics {
    private List<Counter> counters;
    private List<Gauge> gauges;
    private List<Histogram> histograms;
    private List<Meter> meters;
    private List<Timer> timers;
    private String version;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
