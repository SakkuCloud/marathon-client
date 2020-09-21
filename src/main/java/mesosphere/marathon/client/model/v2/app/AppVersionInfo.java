package mesosphere.marathon.client.model.v2.app;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppVersionInfo {
    private String lastScalingAt;
    private String lastConfigChangeAt;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
