package mesosphere.marathon.client.model.v2.pod.status;

import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.Date;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusCondition {
    private String name;
    private String reason;
    private String value;
    private Date lastChanged;
    private Date lastUpdated;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}