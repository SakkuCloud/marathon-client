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
public class Meter {
    private Integer count;
    private String units;

    @JsonProperty("mean_rate")
    @SerializedName("mean_rate")
    private Integer meanRate;

    @JsonProperty("m1_rate")
    @SerializedName("m1_rate")
    private Integer m1Rate;

    @JsonProperty("m5_rate")
    @SerializedName("m5_rate")
    private Integer m5Rate;

    @JsonProperty("m15_rate")
    @SerializedName("m15_rate")
    private Integer m15Rate;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
