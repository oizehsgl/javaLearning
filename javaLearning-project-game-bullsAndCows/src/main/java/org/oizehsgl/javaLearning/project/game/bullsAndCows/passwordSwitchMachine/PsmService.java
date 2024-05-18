package org.oizehsgl.javaLearning.project.game.bullsAndCows.passwordSwitchMachine;

import com.google.common.collect.Collections2;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author oizehsgl
 */
public class PsmService {
    public void test() {
    }

    public static void main(String[] args) {
        int size = 6;
        List<Integer> demoPassword = IntStream.rangeClosed(1, size).boxed().toList();
        List<List<Integer>> guessList = Collections2.permutations(demoPassword).stream().collect(Collectors.toList());
        List<List<Integer>> passwordList = Collections2.permutations(demoPassword).stream().collect(Collectors.toList());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("序数: ");
            Integer index = scanner.nextInt() - 1;
            System.out.print("结果: ");
            Integer answer = scanner.nextInt();
            // 去除多余密码
            Iterator<List<Integer>> passwordIterator = passwordList.iterator();
            while (passwordIterator.hasNext()) {
                List<Integer> password = passwordIterator.next();
                if (!password.get(index).equals(answer)) {
                    passwordIterator.remove();
                }
            }
            // 估计最优猜测
            List<GuessResult> guessResultList = new ArrayList<>();
            Iterator<List<Integer>> guessIterator = guessList.iterator();
            while (guessIterator.hasNext()) {
                List<Integer> guess = guessIterator.next();
                GuessResult guessResult = new GuessResult();
                guessResult.setGuessPassword(guess);
                Integer fourCount = 0;
                Integer unknownRightCount = 0;
                List<Integer> rightCountList = new ArrayList<>(Collections.nCopies(size, 0));
                passwordIterator = passwordList.iterator();
                while (passwordIterator.hasNext()) {
                    int rightCount = 0;
                    List<Integer> password = passwordIterator.next();
                    for (int i = 0; i < password.size(); i++) {
                        if (password.get(i).equals(guess.get(i))) {
                            rightCount++;
                            rightCountList.set(i, rightCountList.get(i) + 1);
                        }
                    }
                    if (rightCount == 4) {
                        fourCount++;
                    }
                }
                int all = passwordList.size();
                for (Integer i : rightCountList) {
                    if (i < all) {
                        unknownRightCount += i;
                    }
                }

                Double fourProbability = fourCount / (double) all;
                Double unknownRightProbability = unknownRightCount / (double) all;
                guessResult.setFourProbability(fourProbability);
                guessResult.setUnknownRightProbability(unknownRightProbability);
                guessResultList.add(guessResult);
            }
            Comparator<GuessResult> fourComparator = (o1, o2) -> ComparisonChain.start()
                    .compare(o1.getFourProbability(), o2.getFourProbability(),
                            Ordering.natural().nullsFirst())
                    .result();
            Comparator<GuessResult> guessResultComparator = (o1, o2) -> ComparisonChain.start()
                    .compare(o1.getUnknownRightProbability(), o2.getUnknownRightProbability(),
                            Ordering.natural().nullsFirst())
                    .result();
            Ordering<GuessResult> compound = Ordering.natural().nullsFirst()
                    .compound(fourComparator)
                    .compound(guessResultComparator);

            for (int i = 0; i < 5; i++) {
                System.out.println(guessResultList.get(i));
            }
            guessResultList.sort(compound);
            for (int i = 0; i < 5; i++) {
                System.out.println(guessResultList.get(i));
            }
            for (int i = guessResultList.size()-5; i < guessResultList.size(); i++) {
                System.out.println(guessResultList.get(i));
            }
        }
    }

}

@Data
class GuessResult implements Comparable<GuessResult> {
    List<Integer> guessPassword;
    Double fourProbability;
    Double unknownRightProbability;

    @Override
    public int compareTo(GuessResult o) {
        return 0;
    }
}