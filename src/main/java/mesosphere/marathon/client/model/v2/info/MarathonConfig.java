package mesosphere.marathon.client.model.v2.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import mesosphere.client.common.ModelUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarathonConfig {
    private String master;
    private Boolean ha;
    private Boolean checkpoint;
    private String executor;
    private String hostname;
    @Builder.Default
    private List<String> features = new ArrayList<>();

    @JsonProperty("failover_timeout")
    @SerializedName("failover_timeout")
    private Integer failoverTimeout;

    @JsonProperty("framework_name")
    @SerializedName("framework_name")
    private String frameworkName;

    @JsonProperty("local_port_min")
    @SerializedName("local_port_min")
    private Integer localPortMin;

    @JsonProperty("local_port_max")
    @SerializedName("local_port_max")
    private Integer localPortMax;

    @JsonProperty("mesos_leader_ui_url")
    @SerializedName("mesos_leader_ui_url")
    private String mesosLeaderUiUrl;

    @JsonProperty("mesos_bridge_name")
    @SerializedName("mesos_bridge_name")
    private Integer mesosBridgeName;

    @JsonProperty("min_revive_offers_interval")
    @SerializedName("min_revive_offers_interval")
    private Integer minReviveOffersInterval;

    @JsonProperty("offer_matching_timeout")
    @SerializedName("offer_matching_timeout")
    private Integer offerMatchingTimeout;

    @JsonProperty("access_control_allow_origin")
    @SerializedName("access_control_allow_origin")
    private String accessControlAllowOrigin;

    @JsonProperty("decline_offer_duration")
    @SerializedName("decline_offer_duration")
    private Integer declineOfferDuration;

    @JsonProperty("default_network_name")
    @SerializedName("default_network_name")
    private String defaultNetworkName;

    @JsonProperty("env_vars_prefix")
    @SerializedName("env_vars_prefix")
    private String envVarsPrefix;

    @JsonProperty("launch_token")
    @SerializedName("launch_token")
    private Integer launchToken;

    @JsonProperty("launch_token_refresh_interval")
    @SerializedName("launch_token_refresh_interval")
    private Integer launchTokenRefreshInterval;

    @JsonProperty("leader_proxy_connection_timeout_ms")
    @SerializedName("leader_proxy_connection_timeout_ms")
    private Integer leaderProxyConnectionTimeoutMs;

    @JsonProperty("leader_proxy_read_timeout_ms")
    @SerializedName("leader_proxy_read_timeout_ms")
    private Integer leaderProxyReadTimeoutMs;

    @JsonProperty("max_instances_per_offer")
    @SerializedName("max_instances_per_offer")
    private Integer maxInstancesPerOffer;

    @JsonProperty("on_elected_prepare_timeout")
    @SerializedName("on_elected_prepare_timeout")
    private Integer onElectedPrepareTimeout;

    @JsonProperty("reconciliation_initial_delay")
    @SerializedName("reconciliation_initial_delay")
    private Integer reconciliationInitialDelay;

    @JsonProperty("reconciliation_interval")
    @SerializedName("reconciliation_interval")
    private Integer reconciliationInterval;

    @JsonProperty("scale_apps_initial_delay")
    @SerializedName("scale_apps_initial_delay")
    private Integer scaleAppsInitialDelay;

    @JsonProperty("scale_apps_interval")
    @SerializedName("scale_apps_interval")
    private Integer scaleAppsInterval;

    @JsonProperty("store_cache")
    @SerializedName("store_cache")
    private Boolean storeCache;

    @JsonProperty("task_launch_confirm_timeout")
    @SerializedName("task_launch_confirm_timeout")
    private Integer taskLaunchConfirmTimeout;

    @JsonProperty("task_lost_expunge_initial_delay")
    @SerializedName("task_lost_expunge_initial_delay")
    private Integer taskLostExpungeInitialDelay;

    @JsonProperty("task_lost_expunge_interval")
    @SerializedName("task_lost_expunge_interval")
    private Integer taskLostExpungeInterval;

    @JsonProperty("webui_url")
    @SerializedName("webui_url")
    private String webuiUrl;

    @JsonProperty("mesos_role")
    @SerializedName("mesos_role")
    private String mesosRole;

    @JsonProperty("task_launch_timeout")
    @SerializedName("task_launch_timeout")
    private Integer taskLaunchTimeout;

    @JsonProperty("task_reservation_timeout")
    @SerializedName("task_reservation_timeout")
    private Integer taskReservationTimeout;

    @JsonProperty("mesos_user")
    @SerializedName("mesos_user")
    private String mesosUser;

    @JsonProperty("mesos_heartbeat_failure_threshold")
    @SerializedName("mesos_heartbeat_failure_threshold")
    private String mesosHeartbeatFailureThreshold;

    @JsonProperty(" mesos_heartbeat_interval")
    @SerializedName(" mesos_heartbeat_interval")
    private String  mesosHeartbeatInterval;


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}