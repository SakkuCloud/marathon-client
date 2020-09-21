package mesosphere.marathon.client.model.v2.app.error;

import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {
    private List<String> errors;
    private String message;
    private String path;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
