package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.entity.IdType;
import org.oizehsgl.sub.service.IdTypeService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * idType test
 *
 * @author oizehsgl
 * @since 3/7/23
 */
@SpringBootTest
public class IdTypeTest {
    @Resource
    private IdTypeService idTypeService;

    @Test
    public void list() {
        idTypeService.list(null).forEach(System.out::println);
        IdType idType = new IdType();
        idTypeService.save(idType);
        idType = new IdType();
        idTypeService.save(idType);
        idTypeService.list(null).forEach(System.out::println);
    }
}
