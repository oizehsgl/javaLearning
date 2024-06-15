package org.oizehsgl.project.onebot.shiro.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目属性
 *
 * @author oizehsgl
 */
@Data
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectProperties {
  private Long groupId;
  private Long robotId;
  private String robotPasswd;
  private List<Long> hostIds;
  private List<Long> playerIds;
}
