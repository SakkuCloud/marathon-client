package mesosphere.marathon.client.model.v2.app.resources;

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
public class ExecutorResources {
    @JsonProperty("cpu shares")
    @SerializedName("cpu shares")
    @Builder.Default
    private Double cpuShares = .1d;
    @JsonProperty("disk space")
    @SerializedName("disk space")
    @Builder.Default
    private Double diskSpace = 10d;
    @Builder.Default
    private Double memory = 32d;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
