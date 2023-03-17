package org.oizehsgl.sub;

import org.junit.Test;

/**
 * facadeTest
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class FacadeTest {
    @Test
    public void testFacade(){
        ComputerFacade computerFacade = new ComputerFacade(new Cpu(),new Ddr(),new Ssd());
        computerFacade.open();
        computerFacade.close();
    }
}
