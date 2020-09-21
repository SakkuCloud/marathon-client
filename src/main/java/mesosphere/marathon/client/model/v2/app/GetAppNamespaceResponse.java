package mesosphere.marathon.client.model.v2.app;

import lombok.*;
import mesosphere.client.common.ModelUtils;

import com.google.gson.annotations.SerializedName;
import mesosphere.marathon.client.model.v2.app.App;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAppNamespaceResponse {
    @SerializedName("*")
    private List<App> apps;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
