package org.oizehsgl.sub;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.autowired.AutowiredService;
import org.oizehsgl.sub.autowired.impl.AutowiredServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * autowired测试
 *
 * @author oizehsgl
 * @since 3/10/23
 */
@SpringBootTest
public class AutowiredTest {
    @Autowired
    private AutowiredServiceImpl autowiredServiceImplA;
    @Autowired
    private AutowiredService autowiredServiceImplB;
    @Autowired
    @Qualifier("autowiredServiceImpl2")
    private AutowiredServiceImpl autowiredServiceImplC;
    @Autowired
    @Qualifier("autowiredServiceImpl3")
    private AutowiredService autowiredServiceImplD;
    @Autowired
    private AutowiredServiceImpl autowiredServiceImpl4;
    @Autowired
    private AutowiredService autowiredServiceImpl5;
    private final AutowiredServiceImpl autowiredServiceImplG;

    private static AutowiredService autowiredServiceImplH;

    //@Autowired
    public AutowiredTest(@Qualifier("autowiredServiceImpl6") AutowiredServiceImpl autowiredServiceImpl, @Qualifier("autowiredServiceImpl7") AutowiredService autowiredService) {
        System.out.println("构造方法");
        this.autowiredServiceImplG = autowiredServiceImpl;
        autowiredServiceImplH = autowiredService;
    }

    private static AutowiredServiceImpl autowiredServiceImplI;

    @Autowired
    public void setAutowiredServiceImplI(@Qualifier("autowiredServiceImpl8") AutowiredServiceImpl autowiredServiceImpl) {
        System.out.println("set方法: @Autowired");
        autowiredServiceImplI = autowiredServiceImpl;
    }

    private AutowiredService autowiredServiceImplJ;
    @Autowired
    @Qualifier("autowiredServiceImpl9")
    private void setAutowiredServiceImplJ(AutowiredService autowiredService) {
        System.out.println("set方法: @Autowired");
        this.autowiredServiceImplJ = autowiredService;
    }
    @PostConstruct
    public void init(){
        System.out.println("PostConstruct");
    }
    @Test
    public void testAutowired() {
        System.out.println(autowiredServiceImplA.getClass());
        System.out.println(autowiredServiceImplB.getClass());
        System.out.println(autowiredServiceImplC.getClass());
        System.out.println(autowiredServiceImplD.getClass());
        System.out.println(autowiredServiceImpl4.getClass());
        System.out.println(autowiredServiceImpl5.getClass());
        System.out.println(autowiredServiceImplG.getClass());
        System.out.println(autowiredServiceImplH.getClass());
        System.out.println(autowiredServiceImplI.getClass());
        System.out.println(autowiredServiceImplJ.getClass());
    }
}
