package org.oizehsgl.sub;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.entity.LogicDelete;
import org.oizehsgl.sub.service.LogicDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * logicDeleteTest
 *
 * @author oizehsgl
 * @since 3/29/23
 */
@SpringBootTest
public class LogicDeleteTest {
    @Autowired
    private LogicDeleteService logicDeleteService;

    @Test
    public void testLogicDeleteBoolean() {
        logicDeleteService.list(null).forEach(System.out::println);
        logicDeleteService.lambdaUpdate().ge(LogicDelete::getId, 2).remove();
        logicDeleteService.list(null).forEach(System.out::println);
        logicDeleteService.list(Wrappers.<LogicDelete>lambdaUpdate().eq(LogicDelete::getDeleted,true)).forEach(System.out::println);
        logicDeleteService.findDeleted().forEach(System.out::println);
        logicDeleteService.findOdd().forEach(System.out::println);
    }
}
