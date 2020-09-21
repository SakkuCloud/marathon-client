package mesosphere.marathon.client.model.v2.info;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAbdicateLeaderResponse {
    private String message;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
