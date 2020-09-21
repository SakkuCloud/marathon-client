package mesosphere.marathon.client;

import java.util.List;
import java.util.Map;

import mesosphere.client.common.HeaderUtils;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import mesosphere.marathon.client.model.v2.app.*;
import mesosphere.marathon.client.model.v2.deployment.Deployment;
import mesosphere.marathon.client.model.v2.deployment.DeploymentResult;
import mesosphere.marathon.client.model.v2.eventSubscriptions.EventSubscriptionRegister;
import mesosphere.marathon.client.model.v2.eventSubscriptions.EventSubscriptions;
import mesosphere.marathon.client.model.v2.group.Group;
import mesosphere.marathon.client.model.v2.group.GroupUpdate;
import mesosphere.marathon.client.model.v2.info.MarathonInfo;
import mesosphere.marathon.client.model.v2.pod.Pod;
import mesosphere.marathon.client.model.v2.queue.Queue;
import mesosphere.marathon.client.model.v2.task.TaskList;
import mesosphere.marathon.client.model.v2.task.TaskSingle;

public interface Marathon {
    // Apps
    @RequestLine("GET /v2/apps")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    VersionedList getApps() throws MarathonException;

    @RequestLine("GET /v2/apps")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    VersionedList getApps(@QueryMap Map<String, String> queryMap) throws MarathonException;

    @RequestLine("GET /v2/apps/{id}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    AppInfoList getApp(@Param("id") String id) throws MarathonException;

    @RequestLine("GET /v2/apps/{id}/tasks")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskList getAppTasks(@Param("id") String id) throws MarathonException;

    @RequestLine("GET /v2/apps/{id}/versions")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    VersionList getAppVersions(@Param("id") String id) throws MarathonException;

    @RequestLine("GET /v2/apps/{id}/versions/{version}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    App getAppVersion(@Param("id") String id, @Param("version") String version) throws MarathonException;

    @RequestLine("GET /v2/tasks")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskList getTasks() throws MarathonException;

    @RequestLine("POST /v2/apps")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    VersionedApp createApp(App app) throws MarathonException;

    @RequestLine("PUT /v2/apps/{app_id}?force={force}&partialUpdate={partialUpdate}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult updateApp(@Param("app_id") String appId, App app, @Param("force") boolean force) throws MarathonException;

    @RequestLine("POST /v2/apps/{id}/restart?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult restartApp(@Param("id") String id, @Param("force") boolean force) throws MarathonException;

    @RequestLine("DELETE /v2/apps/{id}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult deleteApp(@Param("id") String id) throws MarathonException;

    @RequestLine("DELETE /v2/apps/{app_id}/tasks?force={force}&host={host}&scale={scale}&wipe={wipe}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskList deleteAppTasks(@Param("app_id") String appId, @Param("force") boolean force,
                            @Param("host") String host, @Param("scale") boolean scale, @Param("wipe") boolean wipe) throws MarathonException;

    @RequestLine("DELETE /v2/apps/{app_id}/tasks/{task_id}?force={force}&scale={scale}&wipe={wipe}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    TaskSingle deleteAppTask(@Param("app_id") String appId, @Param("task_id") String taskId,
                             @Param("force") boolean force, @Param("scale") boolean scale, @Param("wipe") boolean wipe) throws MarathonException;

    // Groups
    @RequestLine("POST /v2/groups")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult createGroup(GroupUpdate group) throws MarathonException;

    @RequestLine("GET /v2/groups")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Group getGroup(@Param("embed") String embed) throws MarathonException;

    @RequestLine("PUT /v2/groups")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult updateGroup(GroupUpdate group) throws MarathonException;

    @RequestLine("DELETE /v2/groups?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult deleteGroups(@Param("force") String force) throws MarathonException;

    @RequestLine("GET /v2/groups/versions")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    VersionList getGroupsVerions() throws MarathonException;

    @RequestLine("GET /v2/groups/{id}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Group getGroup(@Param("id") String id, @Param("embed") String embed) throws MarathonException;

    @RequestLine("GET /v2/groups/{id}/versions")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    VersionList getGroupVersions(@Param("id") String id) throws MarathonException;

    @RequestLine("DELETE /v2/groups/{id}?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult deleteGroup(@Param("id") String id, @Param("force") boolean force) throws MarathonException;

    @RequestLine("POST /v2/groups/{id}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult createGroup(@Param("id") String id, GroupUpdate group) throws MarathonException;

    @RequestLine("PUT /v2/groups/{id}?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult updateGroup(@Param("id") String id, GroupUpdate group, @Param("force") boolean force) throws MarathonException;

    // Deployments
    @RequestLine("GET /v2/deployments")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    List<Deployment> getDeployments() throws MarathonException;

    @RequestLine("DELETE /v2/deployments/{deployment_id}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult cancelDeploymentAndRollback(@Param("deployment_id") String id) throws MarathonException;

    @RequestLine("DELETE /v2/deployments/{deploymentId}?force=true")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    DeploymentResult cancelDeployment(@Param("deploymentId") String id) throws MarathonException;

    // Event Subscriptions
    @RequestLine("POST /v2/eventSubscriptions?callbackUrl={url}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    public EventSubscriptionRegister register(@Param("url") String url) throws MarathonException;

    @RequestLine("DELETE /v2/eventSubscriptions?callbackUrl={url}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    public EventSubscriptionRegister unregister(@Param("url") String url) throws MarathonException;

    @RequestLine("GET /v2/eventSubscriptions")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    public EventSubscriptions subscriptions() throws MarathonException;

    // Queue
    @RequestLine("GET /v2/queue")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Queue getQueue(@Param("embed") String embed) throws MarathonException;

    // Server Info
    @RequestLine("GET /v2/info")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    MarathonInfo getServerInfo() throws MarathonException;

    // pods
    @RequestLine("GET /v2/pods")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    List<Pod> getPods() throws MarathonException;

    @RequestLine("POST /v2/pods")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Pod createPod(Pod pod) throws MarathonException;

    @RequestLine("GET /v2/pods/{id}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Pod getPod(@Param("id") String id) throws MarathonException;

    @RequestLine("DELETE /v2/pods/{id}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    void deletePod(@Param("id") String id) throws MarathonException;

    @RequestLine("PUT /v2/pods/{id}?force={force}")
    @Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
    Pod updatePod(@Param("id") String id, @Param("force") boolean force, Pod pod) throws MarathonException;

}
