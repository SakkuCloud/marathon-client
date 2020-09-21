package mesosphere.marathon.client.model.v2.pod.status;

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
public class NetworkStatus {
    private String name;
    private List<String> addresses;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
