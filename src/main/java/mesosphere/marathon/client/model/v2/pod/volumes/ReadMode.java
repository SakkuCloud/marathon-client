package mesosphere.marathon.client.model.v2.pod.volumes;

/**
 * @author AliTM
 */
public enum ReadMode {
    RO, RW;

    public static ReadMode fromString(String mode) {
        for (ReadMode readMode : values())
            if (readMode.toString().equalsIgnoreCase(mode))
                return readMode;
        return null;
    }
}
