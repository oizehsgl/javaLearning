package org.oizehsgl.javaLearning.project.game.bullsAndCows.passwordSwitchMachine;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * 密码切换机结果业务对象
 *
 * @author yueyuanzhi
 */
@Data
@Builder
public class ResultBo {
    private Integer bulls;
    private Integer cows;
    private Map<Integer,Boolean> result;
}
