package mesosphere.marathon.client.model.v2.app.health;


import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppCommandCheck {
	private String value;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
