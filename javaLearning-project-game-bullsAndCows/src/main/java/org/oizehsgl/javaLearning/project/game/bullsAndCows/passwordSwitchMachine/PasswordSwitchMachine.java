package org.oizehsgl.javaLearning.project.game.bullsAndCows.passwordSwitchMachine;

import com.google.common.collect.Collections2;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author oizehsgl
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordSwitchMachine {
  /** 当前猜测总数 */
  private Integer count;

  /** 剩余密码数 */
  private List<PasswordBo> passwordBos;

  /** 猜测的密码 */
  private List<GuessBo> guessBos;

  /** 猜测的结果 */
  private List<ResultBo> resultBos;

  /**
   * 初始化密码切换机
   *
   * @param size
   * @return
   */
  @Builder
  public static PasswordSwitchMachine build(Integer size) {
    PasswordSwitchMachine passwordSwitchMachine = new PasswordSwitchMachine();
    List<Integer> password = IntStream.rangeClosed(1, size).boxed().toList();
    List<PasswordBo> passwordBoList = new ArrayList<>();
    for (List<Integer> permutation : Collections2.permutations(password)) {
      passwordBoList.add(PasswordBo.builder().password(permutation).build());
    }
    passwordSwitchMachine.setPasswordBos(passwordBoList);
    passwordSwitchMachine.setCount(0);
    return passwordSwitchMachine;
  }

  public GuessBo optimalGuess() {
    List<Integer> password =
        IntStream.rangeClosed(1, passwordBos.get(0).getPassword().size()).boxed().toList();
    List<GuessBo> guessBoList =
        Collections2.permutations(password).stream().map(GuessBo::valueOf).toList();
    List<AnswerBo> answerBos = new ArrayList<>();
    for (GuessBo guessBo : guessBoList) {
      answerBos.add(guessBo.calculate(passwordBos));
    }
    return null;
  }

  public ResultBo evaluateGuess(GuessBo guessBo) {
    return null;
  }

  public void exclude(ResultBo resultBo) {}
}
