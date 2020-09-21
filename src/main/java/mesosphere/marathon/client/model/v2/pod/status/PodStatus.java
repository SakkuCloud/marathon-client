package mesosphere.marathon.client.model.v2.pod.status;

import lombok.*;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.pod.Pod;

import java.util.Date;
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
public class PodStatus {
    private String id;
    private String message;
    private Pod spec;
    private PodState status;
    private Date statusSince;
    private Date lastChanged;
    private Date lastUpdated;
    private List<PodInstanceStatus> instances;
    private List<TerminationHistory> terminationHistory;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
