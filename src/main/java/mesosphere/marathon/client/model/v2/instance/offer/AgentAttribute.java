package mesosphere.marathon.client.model.v2.instance.offer;

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
public class AgentAttribute {
    private String name;
    private List<NumberRange> ranges;
    private Integer scalar;
    private List<String> set;
    private String text;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
