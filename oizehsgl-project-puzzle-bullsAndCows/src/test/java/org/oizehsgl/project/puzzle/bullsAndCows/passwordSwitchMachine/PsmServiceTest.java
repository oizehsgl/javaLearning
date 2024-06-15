package org.oizehsgl.project.puzzle.bullsAndCows.passwordSwitchMachine;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

/**
 * @author oizehsgl
 */
@SpringBootTest
class PsmServiceTest {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("请输入一个字符串(中间能加空格或符号)");
    String a = input.nextLine();
    System.out.println(a);
  }

  @Test
  public void test() {
    System.out.println("aseitoae");
  }
}
