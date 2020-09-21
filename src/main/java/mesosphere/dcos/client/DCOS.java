package mesosphere.dcos.client;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import mesosphere.client.common.HeaderUtils;
import mesosphere.client.common.ThrowingSupplier;
import mesosphere.dcos.client.model.AuthenticateResponse;
import mesosphere.dcos.client.model.DCOSAuthCredentials;
import mesosphere.dcos.client.model.Secret;
import mesosphere.marathon.client.Marathon;
import mesosphere.marathon.client.MarathonException;
import mesosphere.marathon.client.model.v2.app.App;
import mesosphere.marathon.client.model.v2.app.GetAppNamespaceResponse;
import mesosphere.marathon.client.model.v2.deployment.DeploymentResult;
import mesosphere.marathon.client.model.v2.eventSubscriptions.EventSubscriptionRegister;
import mesosphere.marathon.client.model.v2.eventSubscriptions.EventSubscriptions;
import mesosphere.marathon.client.model.v2.group.Group;
import mesosphere.marathon.client.model.v2.group.GroupUpdate;
import mesosphere.marathon.client.model.v2.info.GetAbdicateLeaderResponse;
import mesosphere.marathon.client.model.v2.info.LeaderInfo;
import mesosphere.marathon.client.model.v2.info.MarathonInfo;
import mesosphere.marathon.client.model.v2.logging.LoggerChange;
import mesosphere.marathon.client.model.v2.logging.Loggers;
import mesosphere.marathon.client.model.v2.metrics.Metrics;
import mesosphere.marathon.client.model.v2.plugin.PluginList;
import mesosphere.marathon.client.model.v2.task.*;

@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface DCOS extends Marathon {
    // DCOS Auth
    @RequestLine("GET /acs/api/v1/auth/login")
    @Headers(HeaderUtils.AUTH_API_SOURCE_HEADER)
    AuthenticateResponse authenticate(DCOSAuthCredentials credentials) throws DCOSException;

    // DCOS Secrets
    @RequestLine("GET /secrets/v1/secret/{secretStore}/{secretPath}")
    @Headers(HeaderUtils.SECRETS_API_SOURCE_HEADER)
    Secret getSecret(@Param("secretStore") String secretStore,
                     @Param("secretPath") String secretPath)
            throws DCOSException;

    // Apps

    /**
     * @param namespace - All apps under this group/subgroups will be returned. Example "/products/us-east"
     * @return applications
     * @throws DCOSException if DC/OS returns non-20x response
     */
    @RequestLine("GET /v2/apps/{namespace}/*")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    GetAppNamespaceResponse getApps(@Param("namespace") String namespace) throws DCOSException;

    @RequestLine("DELETE /v2/apps/{appId}?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult deleteApp(@Param("appId") String appId,
                               @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /v2/apps/{appId}/tasks?host={host}&force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskList deleteAppTasksWithHost(@Param("appId") String appId,
                                    @Param("host") String host,
                                    @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /v2/apps/{appId}/tasks?host={host}&force={force}&scale=true")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult deleteAppTasksAndScaleWithHost(@Param("appId") String appId,
                                                    @Param("host") String host,
                                                    @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /v2/apps/{appId}/tasks?host={host}&force={force}&wipe=true")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskList deleteAppTasksAndWipeWithHost(@Param("appId") String appId,
                                           @Param("host") String host,
                                           @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /v2/apps/{appId}/tasks/{taskId}?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskSingle deleteAppTasksWithTaskId(@Param("appId") String appId,
                                        @Param("taskId") String taskId,
                                        @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /v2/apps/{appId}/tasks/{taskId}?force={force}&scale=true")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult deleteAppTasksAndScaleWithTaskId(@Param("appId") String appId,
                                                      @Param("taskId") String taskId,
                                                      @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /v2/apps/{appId}/tasks/{taskId}?force={force}&wipe=true")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskSingle deleteAppTasksAndWipeWithTaskId(@Param("appId") String appId,
                                               @Param("taskId") String taskId,
                                               @Param("force") boolean force)
            throws DCOSException;

    // Deployments
    @RequestLine("DELETE /v2/deployments/{deploymentId}?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult deleteDeployment(@Param("deploymentId") String id) throws DCOSException;

    // Groups
    @RequestLine("GET /v2/groups")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Group getGroups() throws DCOSException;

    @RequestLine("PUT /v2/groups?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult modifyGroup(@Param("force") boolean force, GroupUpdate group) throws DCOSException;

    @RequestLine("POST /v2/groups?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult createGroup(@Param("force") boolean force, GroupUpdate group) throws DCOSException;

    @RequestLine("DELETE /v2/groups?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult deleteGroup(@Param("force") boolean force) throws DCOSException;

    @RequestLine("GET /v2/groups/versions")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    List<String> getGroupVersion() throws DCOSException;

    @RequestLine("PUT /v2/groups/{id}?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Group modifyGroups(@Param("id") String id, GroupUpdate group,
                       @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("POST /v2/groups/{id}?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Group createGroups(@Param("id") String id,
                       @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /v2/groups/{id}?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult deleteGroups(@Param("id") String id,
                                  @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("GET /v2/groups/{id}/versions")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult getGroupVersion(@Param("id") String id) throws DCOSException;

    // Tasks
    @RequestLine("GET /v2/tasks?status={status}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskList getTasks(@Param("status") Status.Condition status) throws DCOSException;

    @RequestLine("POST /v2/tasks/delete?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeleteTaskCriteria deleteTask(@Param("force") boolean force, DeleteTaskCriteria deleteTaskBody) throws DCOSException;

    @RequestLine("DELETE /v2/tasks/delete?force={force}&scale=true")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskList deleteTaskAndScale(@Param("force") boolean force, DeleteTaskCriteria deleteTaskBody)
            throws DCOSException;

    @RequestLine("DELETE /v2/tasks/delete?force={force}&wipe=true")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskList deleteTaskAndWipe(@Param("force") boolean force, DeleteTaskCriteria deleteTaskBody)
            throws DCOSException;

    // Event Subscriptions
    @RequestLine("GET /v2/eventSubscriptions")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    EventSubscriptions getSubscriptions() throws DCOSException;

    @RequestLine("POST /v2/eventSubscriptions?callbackUrl={url}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    EventSubscriptionRegister postSubscriptions(@Param("url") String url) throws DCOSException;

    @RequestLine("DELETE /v2/eventSubscriptions?callbackUrl={url}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    EventSubscriptionRegister deleteSubscriptions(@Param("url") String url) throws DCOSException;

    // Server Info
    @RequestLine("GET /v2/info")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    MarathonInfo getInfo() throws DCOSException;

    // LeaderInfo
    @RequestLine("GET /v2/leader")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    LeaderInfo getLeader() throws DCOSException;

    @RequestLine("DELETE /v2/leader")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    GetAbdicateLeaderResponse deleteLeader(@Param("backup?") String backup, @Param("restore?") String restore) throws DCOSException;

    // Plugins
    @RequestLine("GET /v2/plugins")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    PluginList getPlugin() throws DCOSException;

    @RequestLine("GET /v2/plugins/{pluginId}/{path}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    void getPlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    @RequestLine("PUT /v2/plugins/{pluginId}/{path}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    void putPlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    @RequestLine("POST /v2/plugins/{pluginId}/{path}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    void postPlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    @RequestLine("DELETE /v2/plugins/{pluginId}/{path}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    void deletePlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    // Queue
    @RequestLine("DELETE /v2/queue/{appId}/delay")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    void deleteQueueDelay(@Param("appId") String appId) throws DCOSException;

    // Miscellaneous
    @RequestLine("GET /ping")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    String getPing() throws DCOSException;

    @RequestLine("GET /metrics")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Metrics getMetrics() throws DCOSException;

    @RequestLine("GET /logging")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Loggers getLogging() throws MarathonException;

    @RequestLine("POST /logging")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Map<String, String> updateLogger(LoggerChange loggerChange);


    // Convenience methods for identifiable resources.
    default Optional<App> maybeApp(final String id) throws DCOSException {
        return resource(() -> getApp(id).getApps().get(0));
    }

    default Optional<Group> maybeGroup(String id) throws DCOSException {
        return resource(() -> getGroup(id));
    }

    default Optional<Secret> maybeSecret(final String secretStore, final String secretPath) throws DCOSException {
        return resource(() -> getSecret(secretStore, secretPath));
    }

    default Optional<GetAppNamespaceResponse> maybeApps(final String namespace) throws DCOSException {
        return resource(() -> getApps(namespace));
    }

    /**
     * Calls the supplied {@code resourceSupplier} to retrieve a DCOS resource of type T.
     * <p>
     * If a {@link DCOSException} is thrown by the {@code resourceSupplier}, it will be caught. If
     * {@link DCOSException#getStatus()} is 404, then an empty optional will be returned. Any other
     * {@link DCOSException} will be rethrown.
     *
     * @param resourceSupplier {@link ThrowingSupplier} instance for accessing the resource.
     * @param <T>              The resource type
     * @return The optional resource.
     * @throws DCOSException if a non-404 DCOSException is thrown.
     */
    default <T> Optional<T> resource(
            ThrowingSupplier<T, DCOSException> resourceSupplier)
            throws DCOSException {
        try {
            return Optional.of(resourceSupplier.get());
        } catch (DCOSException e) {
            if (e.getStatus() == 404) {
                return Optional.empty();
            }

            throw e;
        }
    }
}
