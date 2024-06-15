package org.oizehsgl.project.puzzle.bullsAndCows.passwordSwitchMachine;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author oizehsgl
 */
@Data
public class AnswerBo {

  private Map<Integer, Double> probability;
  private GuessBo guessBo;

  @Builder
  public static AnswerBo build(List<ResultBo> resultBos) {
    Map<Integer, Integer> resultSum = new HashMap<>();
    for (ResultBo resultBo : resultBos) {
      for (Map.Entry<Integer, Boolean> integerIntegerEntry : resultBo.getResult().entrySet()) {
        Integer key = integerIntegerEntry.getKey();
        Integer sum = resultSum.getOrDefault(key, 0);
        if (integerIntegerEntry.getValue()) {
          sum += 1;
        }
        resultSum.put(key, sum);
      }
    }
    Map<Integer, Double> resultProbability = new HashMap<>();
    for (Map.Entry<Integer, Integer> integerIntegerEntry : resultSum.entrySet()) {
      resultProbability.put(
          integerIntegerEntry.getKey(), integerIntegerEntry.getValue() / (double) resultSum.size());
    }
    AnswerBo answerBo = new AnswerBo();
    answerBo.setProbability(resultProbability);
    return answerBo;
  }
}
