package mesosphere.marathon.client.model.v2.plugin;

import java.util.List;

import lombok.*;
import mesosphere.client.common.ModelUtils;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plugin {
    private String id;
    private String implementation;
    private Info info;
    private String plugin;
    private List<String> tags;


    @Data
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Info {
        private String version;
        private List<Object> array;
        private Boolean test;


        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }


    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
