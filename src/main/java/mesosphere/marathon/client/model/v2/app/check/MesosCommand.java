package mesosphere.marathon.client.model.v2.app.check;

import mesosphere.client.common.ModelUtils;

/**
 * @author AliTM
 */

public abstract class MesosCommand {
    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
