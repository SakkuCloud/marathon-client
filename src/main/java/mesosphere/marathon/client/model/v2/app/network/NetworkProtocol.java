package mesosphere.marathon.client.model.v2.app.network;

/**
 * @author AliTM
 */

public enum NetworkProtocol {
    tcp, udp;


    public static NetworkProtocol fromString(String network) {
        for (NetworkProtocol networkProtocol : values())
            if (networkProtocol.toString().equalsIgnoreCase(network))
                return networkProtocol;
        return null;
    }
}
