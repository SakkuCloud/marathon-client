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
public class ErrorResponse {
    private String message;
    private ErrorDetail[] details;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
