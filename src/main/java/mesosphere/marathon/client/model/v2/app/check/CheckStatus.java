package mesosphere.marathon.client.model.v2.app.check;

import lombok.*;
import mesosphere.client.common.ModelUtils;

/**
 * @author AliTM
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckStatus {
    private CommandStatus command;
    private HttpStatus http;
    private TcpStatus tcp;

    @Data
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommandStatus {
        private Integer exitCode;

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }

    @Data
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HttpStatus {
        private Integer statusCode;

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }

    @Data
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TcpStatus {
        private Boolean succeeded;

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }
}
