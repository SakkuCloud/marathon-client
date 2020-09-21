package mesosphere.marathon.client.model.v2.pod.linux;

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
public class LinuxInfo {
    private IPCInfo ipcInfo;
    private Seccomp seccomp;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
