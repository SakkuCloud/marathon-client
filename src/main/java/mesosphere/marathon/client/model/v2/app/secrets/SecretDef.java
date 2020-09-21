package mesosphere.marathon.client.model.v2.app.secrets;

import lombok.*;
import mesosphere.client.common.ModelUtils;


@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecretDef {
    private String source;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
