package mesosphere.marathon.client.model.v2.app.check;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author AliTM
 */

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ShellCommand extends MesosCommand {
    private String shell;
}
