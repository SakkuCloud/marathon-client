package mesosphere.marathon.client.model.v2.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import mesosphere.client.common.ModelUtils;

/**
 * @author AliTM
 */

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HttpConfig {
    @SerializedName("http_port")
    @JsonProperty("http_port")
    private Integer httpPort;
    @SerializedName("https_port")
    @JsonProperty("https_port")
    private Integer httpsPort;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
