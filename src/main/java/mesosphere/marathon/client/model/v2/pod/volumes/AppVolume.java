package mesosphere.marathon.client.model.v2.pod.volumes;

import com.google.gson.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import mesosphere.client.common.ModelUtils;

import java.lang.reflect.Type;

/**
 * @author AliTM
 */

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AppVolume {
    private String containerPath;


    public static class AppVolumeAdapter implements JsonDeserializer<AppVolume>, JsonSerializer<AppVolume> {
        @Override
        public AppVolume deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            if (jsonObject.has("external"))
                return context.deserialize(json, AppExternalVolume.class);
             else if (jsonObject.has("persistent"))
                return context.deserialize(json, AppPersistentVolume.class);
            else if (jsonObject.has("hostPath"))
                return context.deserialize(json, AppHostVolume.class);
             else if (jsonObject.has("secret"))
                return context.deserialize(json, AppSecretVolume.class);
             else
                throw new IllegalArgumentException("Can't deserialize AppVolume");
        }

        @Override
        public JsonElement serialize(AppVolume volume, Type type, JsonSerializationContext context) {
            return context.serialize(volume);
        }
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
