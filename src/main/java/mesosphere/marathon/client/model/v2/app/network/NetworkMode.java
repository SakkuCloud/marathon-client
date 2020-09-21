package mesosphere.marathon.client.model.v2.app.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author AliTM
 */


public enum NetworkMode {
    CONTAINER("container"),
    @JsonProperty("container/bridge")
    CONTAINER_BRIDGE("container/bridge"),
    HOST("host");

    private String value;

    NetworkMode(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
