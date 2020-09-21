package mesosphere.marathon.client.model.v2.instance.offer;

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
public class NumberRange {
    private Integer begin;
    private Integer end;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
