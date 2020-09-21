package mesosphere.marathon.client.model.v2.app.constraints;

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
public class Constraint {
    private String fieldName;
    private ConstraintOperator operator;
    private String value;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
