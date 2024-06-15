package org.oizehsgl.project.puzzle.bullsAndCows.passwordSwitchMachine;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

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
