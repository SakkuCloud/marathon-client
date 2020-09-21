package mesosphere.marathon.client.model.v2.app;

import lombok.*;
import lombok.experimental.SuperBuilder;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.model.v2.task.Task;
import mesosphere.marathon.client.model.v2.task.TaskFailure;
import mesosphere.marathon.client.model.v2.app.readiness.TaskReadinessCheckResult;
import mesosphere.marathon.client.model.v2.task.TaskStats;

import java.util.Collection;
import java.util.List;

/**
 * @author AliTM
 */

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AppInfo extends App {
    private Collection<Task> tasks;
    private TaskStats tasksStats;
    private Integer tasksStaged;
    private Integer tasksRunning;
    private Integer tasksHealthy;
    private Integer tasksUnhealthy;
    private TaskFailure lastTaskFailure;
    private List<Deployment> deployments;
    private List<TaskReadinessCheckResult>  readinessCheckResults;
    private String version;


    @Data
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Deployment {
        private String id;

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }
}
