package org.oizehsgl.javaLearning.project.game.bullsAndCows.passwordSwitchMachine;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 密码切换机猜测对象
 *
 * @author oizehsgl
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuessBo {
  PasswordBo guessPasswordBo;

  public static GuessBo valueOf(List<Integer> integers) {
    GuessBo guessBo = new GuessBo();
    guessBo.setGuessPasswordBo(new PasswordBo(integers));
    return guessBo;
  }

  public AnswerBo calculate(List<PasswordBo> passwordBoList) {
    List<ResultBo> resultBos = passwordBoList.stream().map(p -> p.calculate(this)).toList();
    return AnswerBo.builder().resultBos(resultBos).build();
  }
}
