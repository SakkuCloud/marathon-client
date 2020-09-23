package mesosphere.marathon.client.model.v2.pod.volumes;

import com.google.gson.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public abstract class PodVolume {
    private String name;


    public static class PodVolumeAdapter implements JsonSerializer<PodVolume>, JsonDeserializer<PodVolume> {
        @Override
        public PodVolume deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            if (jsonObject.has("secret"))
                return context.deserialize(json, PodSecretVolume.class);
            else if (jsonObject.has("persistent"))
                return context.deserialize(json, PodPersistentVolume.class);
            else if (jsonObject.has("host"))
                return context.deserialize(json, PodHostVolume.class);
            else
                return context.deserialize(json, PodEphemeralVolume.class);
        }

        @Override
        public JsonElement serialize(PodVolume volume, Type type, JsonSerializationContext context) {
            return context.serialize(volume);
        }
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}

