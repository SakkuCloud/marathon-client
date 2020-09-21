package mesosphere.marathon.client.model.v2.app.health;

/**
 * @author AliTM
 */

public enum AppHealthCheckProtocol {
    HTTP, HTTPS, TCP, COMMAND, MESOS_TCP, MESOS_HTTP, MESOS_HTTPS;
}
