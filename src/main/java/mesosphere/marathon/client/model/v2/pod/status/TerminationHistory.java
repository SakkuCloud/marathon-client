package mesosphere.marathon.client.model.v2.pod.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.Date;
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
public class TerminationHistory {
    @JsonProperty("instanceID ")
    @SerializedName("instanceID")
    private String instanceId;
    private String message;
    private List<ContainerTerminationHistory> containers;
    private Date startedAt;
    private Date terminatedAt;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
