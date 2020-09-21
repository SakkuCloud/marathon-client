package mesosphere.marathon.client.model.v2.app;

import lombok.*;
import mesosphere.client.common.ModelUtils;

/**
 * @author AliTM
 * app.unreachableStrategy.UnreachableEnabled
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnreachableStrategy {
    private Integer expungeAfterSeconds;
    private Integer inactiveAfterSeconds;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
