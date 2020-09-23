package mesosphere.marathon.client.model.v2.app;

import java.util.*;

import lombok.*;
import lombok.experimental.SuperBuilder;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.common.KillSelection;
import mesosphere.marathon.client.model.v2.app.artifact.Artifact;
import mesosphere.marathon.client.model.v2.app.check.Check;
import mesosphere.marathon.client.model.v2.app.container.Container;
import mesosphere.marathon.client.model.v2.app.health.AppHealthCheck;
import mesosphere.marathon.client.model.v2.app.network.IpAddress;
import mesosphere.marathon.client.model.v2.app.network.Network;
import mesosphere.marathon.client.model.v2.app.network.PortDefinition;
import mesosphere.marathon.client.model.v2.app.readiness.ReadinessCheck;
import mesosphere.marathon.client.model.v2.app.resources.ExecutorResources;
import mesosphere.marathon.client.model.v2.app.secrets.SecretDef;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class App {
    private String id;
    private String cmd;
    private List<String> args;
    private String user;
    @Builder.Default
    private Integer instances = 1;
    @Builder.Default
    private Double cpus = 1d;
    @Builder.Default
    private Double mem = 128d;
    @Builder.Default
    private Double disk = 0d;
    @Builder.Default
    private Double gpus = 0d;
    @Builder.Default
    private Integer backoffSeconds = 1;
    @Builder.Default
    private Double backoffFactor = 1.15d;
    @Builder.Default
    private Integer maxLaunchDelaySeconds = 300;
    private Collection<String> uris;
    private List<List<String>> constraints;
    private Collection<String> acceptedResourceRoles;
    private Container container;
    private Map<String, Object> env;
    private Map<String, String> labels;
    private IpAddress ipAddress;
    private Residency residency;
    private Integer taskKillGracePeriodSeconds;
    private Map<String, SecretDef> secrets;
    private String executor;
    private List<Artifact> fetch;
    private List<String> storeUrls;
    private List<Integer> ports;
    private List<PortDefinition> portDefinitions;
    @Builder.Default
    private Boolean requirePorts = false;
    private Collection<String> dependencies;
    private AppVersionInfo versionInfo;
    private List<AppHealthCheck> healthChecks;
    private List<ReadinessCheck> readinessChecks;
    private UpgradeStrategy upgradeStrategy;
    private List<Network> networks;
    private Check check;
    private ExecutorResources executorResources;
    @Builder.Default
    private KillSelection killSelection = KillSelection.YOUNGEST_FIRST;
    private String role;
    private Boolean tty;
    private UnreachableStrategy unreachableStrategy;


    public void addConstraint(String attribute, String operator, String value) {
        if (this.constraints == null) {
            this.constraints = new ArrayList<>();
        }
        List<String> constraint = new ArrayList<String>(3);
        constraint.add(attribute == null ? "" : attribute);
        constraint.add(operator == null ? "" : operator);
        constraint.add(value == null ? "" : value);
        this.constraints.add(constraint);
    }

    public void addAcceptedResourceRole(String role) {
        if (this.acceptedResourceRoles == null) {
            this.acceptedResourceRoles = new HashSet<>();
        }

        this.acceptedResourceRoles.add(role);
    }

    public void addLabel(final String key, final String value) {
        if (key != null && key.trim().length() > 0) {
            if (this.labels == null) {
                this.labels = new HashMap<>();
            }
            this.labels.put(key, value == null ? "" : value);
        }
    }

    public void addDependency(final String dependency) {
        if (dependency != null && dependency.trim().length() > 0) {
            if (this.dependencies == null) {
                this.dependencies = new HashSet<>();
            }
            this.dependencies.add(dependency);
        }
    }

    public void addUri(String uri) {
        if (this.uris == null) {
            this.uris = new ArrayList<>();
        }
        this.uris.add(uri);
    }

    public void addPort(int port) {
        if (this.ports == null) {
            this.ports = new ArrayList<>();
        }
        this.ports.add(port);
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
