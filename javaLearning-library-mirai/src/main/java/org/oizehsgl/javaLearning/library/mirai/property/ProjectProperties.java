package org.oizehsgl.javaLearning.library.mirai.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目属性
 *
 * @author yueyuanzhi
 */
@Data
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectProperties {
    private Long groupId;
    private Long robotId;
    private List<Long> hostIds;
    private List<Long> playerIds;
}
