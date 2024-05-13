package org.oizehsgl.javaLearning.project.game.bullsAndCows.passwordSwitchMachine;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

/**
 * @author yueyuanzhi
 */
@SpringBootTest
class PsmServiceTest {
    @Test
    public void test() {
        System.out.println("aseitoae");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串(中间能加空格或符号)");
        String a = input.nextLine();
        System.out.println(a);
    }
}