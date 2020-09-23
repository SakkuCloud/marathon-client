package mesosphere.client.common;

import com.google.gson.*;
import mesosphere.marathon.client.model.v2.app.UnreachableStrategy;
import mesosphere.marathon.client.model.v2.app.check.MesosCommand;
import mesosphere.marathon.client.model.v2.pod.volumes.*;


public class ModelUtils {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting()
            .disableHtmlEscaping()
            .registerTypeAdapter(AppVolume.class, new AppVolume.AppVolumeAdapter())
            .registerTypeAdapter(PodVolume.class, new PodVolume.PodVolumeAdapter())
            .registerTypeAdapter(MesosCommand.class, new MesosCommand.MesosCommandAdapter())
            .registerTypeAdapter(UnreachableStrategy.class, new UnreachableStrategy.UnreachableStrategyAdapter())
            .create();

    public static String toString(Object o) {
        return GSON.toJson(o);
    }

}
