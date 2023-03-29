package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.entity.IdType;
import org.oizehsgl.sub.service.IdTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * idType test
 *
 * @author oizehsgl
 * @since 3/7/23
 */
@SpringBootTest
public class IdTypeTest {
    @Autowired
    private IdTypeService idTypeService;

    @Test
    public void list() {
        idTypeService.list(null).forEach(System.out::println);
        IdType idType = new IdType();
        idType.setData("1");
        idTypeService.save(idType);
        idType = new IdType();
        idType.setData("2");
        idTypeService.save(idType);
        idTypeService.list(null).forEach(System.out::println);
    }
}
