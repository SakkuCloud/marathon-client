package mesosphere.marathon.client.model.v2.app;

import lombok.*;
import mesosphere.client.common.ModelUtils;

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
public class VersionedList {
    private List<VersionedApp> apps;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
