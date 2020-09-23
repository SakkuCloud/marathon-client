package mesosphere.marathon.client.model.v2.app;

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
public class AppInfoSingle {
    private AppInfo app;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
