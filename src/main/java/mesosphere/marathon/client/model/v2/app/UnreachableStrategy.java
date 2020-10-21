package mesosphere.marathon.client.model.v2.app;

import com.google.gson.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.pod.volumes.*;

import java.lang.reflect.Type;

/**
 * @author AliTM
 */

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class UnreachableStrategy {

    public static class UnreachableStrategyAdapter implements JsonDeserializer<UnreachableStrategy>, JsonSerializer<UnreachableStrategy> {
        @Override
        public UnreachableStrategy deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
            if (json.getAsString().equalsIgnoreCase("disabled"))
                return null;
            return context.deserialize(json, UnreachableEnabled.class);
        }

        @Override
        public JsonElement serialize(UnreachableStrategy strategy, Type type, JsonSerializationContext context) {
            return context.serialize(strategy);
        }
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
