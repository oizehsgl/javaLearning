package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.jpa.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * jpaTest
 *
 * @author oizehsgl
 * @since 3/19/23
 */
@SpringBootTest
public class JpaTest {
    @Autowired
    private TableService tableService;
    @Test
    public void testJpa(){
        System.out.println(tableService.findAll());
    }
}
