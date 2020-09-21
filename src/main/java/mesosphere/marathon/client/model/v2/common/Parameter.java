package mesosphere.marathon.client.model.v2.common;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parameter {
    private String key;
    private String value;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
