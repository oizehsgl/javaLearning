package org.oizehsgl.sub.annotation;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * demoLogSubService
 *
 * @author oizehsgl
 * @since 4/10/23
 */
@Service
public class DemoLogSubService extends DemoLogSupService {


    @Override
    @DemoLog
    public String method2(List<Integer> integers, String... strings) {
        return method(integers, strings);
    }

    @Override
    public String method3(List<Integer> integers, String... strings) {
        return method(integers, strings);
    }

    @DemoLog
    public String method4(List<Integer> integers, String... strings) {
        return method(integers, strings);
    }

    public String method5(List<Integer> integers, String... strings) {
        return method(integers, strings);
    }
}
