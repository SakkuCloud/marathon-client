package mesosphere.marathon.client.model.v2.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
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
public class Timer {
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

    @JsonProperty("mean_rate")
    @SerializedName("mean_rate")
    private Integer meanRate;

    @JsonProperty("rate_units")
    @SerializedName("rate_units")
    private String rateUnits;

    @JsonProperty("m1_rate")
    @SerializedName("m1_rate")
    private Integer m1Rate;

    @JsonProperty("m5_rate")
    @SerializedName("m5_rate")
    private Integer m5Rate;

    @JsonProperty("m15_rate")
    @SerializedName("m15_rate")
    private Integer m15Rate;

    @JsonProperty("duration_units")
    @SerializedName("duration_units")
    private String durationUnits;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}