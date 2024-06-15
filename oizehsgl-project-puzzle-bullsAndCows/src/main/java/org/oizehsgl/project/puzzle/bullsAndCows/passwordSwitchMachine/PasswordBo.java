package org.oizehsgl.project.puzzle.bullsAndCows.passwordSwitchMachine;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * @author oizehsgl
 */
@Data
@Builder
public class PasswordBo {
  private List<Integer> password;

  public ResultBo calculate(GuessBo guessBo) {
    ResultBo resultBo = ResultBo.builder().result(new HashMap<>()).bulls(0).cows(0).build();
    List<Integer> guess = guessBo.getGuessPasswordBo().getPassword();
    for (int i = 0; i < password.size(); i++) {
      if (guess.get(i).equals(password.get(i))) {
        resultBo.getResult().put(i, Boolean.TRUE);
      } else {
        if (password.contains(guess.get(i))) {}
        resultBo.getResult().put(i, Boolean.FALSE);
      }
    }
    return null;
  }
}
