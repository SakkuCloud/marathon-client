package mesosphere.marathon.client.model.v2.info;

import java.util.Collection;

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
public class MarathonInfo {
    private String name;
    private String version;
    private String buildref;
    private Boolean elected;
    private String leader;
    private String frameworkId;

    @JsonProperty("marathon_config")
    @SerializedName("marathon_config")
    private MarathonConfig marathonConfig;

    @JsonProperty("zookeeper_config")
    @SerializedName("zookeeper_config")
    private ZookeeperConfig zookeeperConfig;

    @JsonProperty("http_config")
    @SerializedName("http_config")
    private HttpConfig httpConfig;

    @JsonProperty("event_subscriber")
    @SerializedName("event_subscriber")
    private EventSubscriber eventSubscriber;


    @Data
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventSubscriber {
        private String type;
        @JsonProperty("http_endpoints")
        @SerializedName("http_endpoints")
        private Collection<String> httpEndpoints;

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
