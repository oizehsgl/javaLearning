package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.entity.DataInterface;
import org.oizehsgl.sub.entity.IdType;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * dataInterfaceTest
 *
 * @author oizehsgl
 * @since 3/31/23
 */
@SpringBootTest
public class DataInterfaceTest {
    @Test
    public void testDataInterface(){
        DataInterface dataInterface = IdType.builder().data("data0").build();
        System.out.println(dataInterface.getData());
        dataInterface.setData("data1");
        System.out.println(dataInterface.getData());
    }
}
