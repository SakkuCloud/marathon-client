package mesosphere.marathon.client.model.v2.eventSubscriptions;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventSubscriptions {
    @Builder.Default
    private List<String> callbackUrls = new ArrayList<>();


    @Override
    public String toString() {
        return ModelUtils.GSON.toString();
    }
}
