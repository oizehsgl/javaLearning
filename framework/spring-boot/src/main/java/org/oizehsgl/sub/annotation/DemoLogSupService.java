package org.oizehsgl.sub.annotation;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * demoLogSupService
 *
 * @author oizehsgl
 * @since 4/10/23
 */
@Service
public class DemoLogSupService {

    public String method(List<Integer> integers, String... strings) {
        System.out.println("----------------------------------------");
        System.out.printf("执行了%s方法%n", Thread.currentThread().getStackTrace()[2].getMethodName());
        System.out.println("----------------------------------------");
        return Thread.currentThread().getStackTrace()[1].getMethodName();
    }

    @DemoLog
    public String method1(List<Integer> integers, String... strings) {
        return method(integers, strings);
    }

    @DemoLog
    public String method2(List<Integer> integers, String... strings) {
        return method(integers, strings);
    }

    @DemoLog
    public String method3(List<Integer> integers, String... strings) {
        return method(integers, strings);
    }
}
