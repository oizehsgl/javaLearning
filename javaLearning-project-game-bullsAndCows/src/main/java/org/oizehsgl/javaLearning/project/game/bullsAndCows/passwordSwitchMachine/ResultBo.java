package org.oizehsgl.javaLearning.project.game.bullsAndCows.passwordSwitchMachine;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

/**
 * 密码切换机结果业务对象
 *
 * @author oizehsgl
 */
@Data
@Builder
public class ResultBo {
  private Integer bulls;
  private Integer cows;
  private Map<Integer, Boolean> result;
}
