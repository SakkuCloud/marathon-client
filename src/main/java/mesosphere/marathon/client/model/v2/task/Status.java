package mesosphere.marathon.client.model.v2.task;

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
public class Status {
    private Condition condition;
    private String mesosStatus;
    private NetworkInfo networkInfo;
    private Date stagedAt;
    private Date startedAt ;


    public enum Condition {
        Error, Failed, Finished, Killed, Killing, Running, Staging, Starting, Unreachable, UnreachableInactive, Gone, Dropped, Unknown
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}

