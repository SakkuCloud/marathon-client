package mesosphere.marathon.client.model.v2.app.check;

import com.google.gson.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.pod.volumes.*;

import java.lang.reflect.Type;

/**
 * @author AliTM
 */

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class MesosCommand {

    public static class MesosCommandAdapter implements JsonSerializer<MesosCommand>, JsonDeserializer<MesosCommand> {
        @Override
        public MesosCommand deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            if (jsonObject.has("shell"))
                return context.deserialize(json, ShellCommand.class);
            else if (jsonObject.has("argv"))
                return context.deserialize(json, ArgvCommand.class);
            else
                return null;

        }

        @Override
        public JsonElement serialize(MesosCommand command, Type type, JsonSerializationContext context) {
            return context.serialize(command);
        }
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
