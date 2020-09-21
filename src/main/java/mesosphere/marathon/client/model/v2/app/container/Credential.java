package mesosphere.marathon.client.model.v2.app.container;

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
public class Credential {
    private String principal;
    private String secret;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
