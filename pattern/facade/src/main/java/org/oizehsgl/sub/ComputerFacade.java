package org.oizehsgl.sub;

/**
 * facade
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class ComputerFacade implements ComputerAccessories {
    private Cpu cpu;
    private Ddr ddr;
    private Ssd ssd;

    public ComputerFacade(Cpu cpu, Ddr ddr, Ssd ssd) {
        this.cpu = cpu;
        this.ddr = ddr;
        this.ssd = ssd;
    }

    @Override
    public void open() {
        cpu.open();
        ddr.open();
        ssd.open();
    }

    @Override
    public void close() {
        ssd.close();
        ddr.close();
        cpu.close();
    }
}
