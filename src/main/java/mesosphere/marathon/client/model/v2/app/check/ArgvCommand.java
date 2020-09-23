package mesosphere.marathon.client.model.v2.app.check;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

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
public class ArgvCommand extends MesosCommand {
    private List<String> argv;
}
