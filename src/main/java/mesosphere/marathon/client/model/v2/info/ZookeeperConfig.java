package mesosphere.marathon.client.model.v2.info;

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
public class ZookeeperConfig {

    private String zk;

    @JsonProperty("zk_compression")
    @SerializedName("zk_compression")
    private Boolean zkCompression;

    @JsonProperty("zk_compression_threshold")
    @SerializedName("zk_compression_threshold")
    private Integer zkCompressionThreshold;

    @JsonProperty("zk_connection_timeout")
    @SerializedName("zk_connection_timeout")
    private Integer zkConnectionTimeout;

    @JsonProperty("zk_max_node_size")
    @SerializedName("zk_max_node_size")
    private Integer zkMaxNodeSize;

    @JsonProperty("zk_timeout")
    @SerializedName("zk_timeout")
    private Integer zkTimeout;

    @JsonProperty("zk_session_timeout")
    @SerializedName("zk_session_timeout")
    private Integer zkSessionTimeout;

    @JsonProperty("zk_max_versions")
    @SerializedName("zk_max_versions")
    private Integer zkMaxVersions;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
