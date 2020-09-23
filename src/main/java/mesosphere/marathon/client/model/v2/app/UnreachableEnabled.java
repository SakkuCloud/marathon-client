package mesosphere.marathon.client.model.v2.app;

import lombok.*;

/**
 * @author AliTM
 */

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UnreachableEnabled extends UnreachableStrategy {
    private Integer expungeAfterSeconds;
    private Integer inactiveAfterSeconds;
}
