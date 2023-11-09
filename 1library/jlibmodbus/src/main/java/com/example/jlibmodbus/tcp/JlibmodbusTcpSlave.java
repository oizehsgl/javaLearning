package com.example.jlibmodbus.tcp;

import com.example.jlibmodbus.JlibmodbusEventListener;
import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.data.DataHolder;
import com.intelligt.modbus.jlibmodbus.data.ModbusHoldingRegisters;
import com.intelligt.modbus.jlibmodbus.exception.IllegalDataAddressException;
import com.intelligt.modbus.jlibmodbus.exception.IllegalDataValueException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.slave.ModbusSlave;
import com.intelligt.modbus.jlibmodbus.slave.ModbusSlaveFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oizehsgl
 * @since 7/11/23
 */
@Component
public class JlibmodbusTcpSlave implements CommandLineRunner {
    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) {
        try {
            // 创建tcp参数对象
            TcpParameters tcpParameters = new TcpParameters();
            tcpParameters.setHost(InetAddress.getLocalHost());
            tcpParameters.setKeepAlive(true);
            tcpParameters.setPort(Modbus.TCP_PORT);

            // 创建slave
            final ModbusSlave slave;
            slave = ModbusSlaveFactory.createModbusSlaveTCP(tcpParameters);
            slave.setReadTimeout(0); // if not set default timeout is 1000ms, I think this must be set to 0 (infinitive timeout)
            Modbus.setLogLevel(Modbus.LogLevel.LEVEL_DEBUG);

            MyOwnDataHolder dh = new MyOwnDataHolder();
            dh.addEventListener(new JlibmodbusEventListener() {
                @Override
                public void onWriteToSingleCoil(int address, boolean value) {
                    System.out.print("onWriteToSingleCoil: address " + address + ", value " + value);
                }

                @Override
                public void onWriteToMultipleCoils(int address, int quantity, boolean[] values) {
                    System.out.print("onWriteToMultipleCoils: address " + address + ", quantity " + quantity);
                }

                @Override
                public void onWriteToSingleHoldingRegister(int address, int value) {
                    System.out.print("onWriteToSingleHoldingRegister: address " + address + ", value " + value);
                }

                @Override
                public void onWriteToMultipleHoldingRegisters(int address, int quantity, int[] values) {
                    System.out.print("onWriteToMultipleHoldingRegisters: address " + address + ", quantity " + quantity);
                }
            });

            slave.setDataHolder(dh);
            ModbusHoldingRegisters hr = new ModbusHoldingRegisters(10);
            hr.set(0, 12345);
            slave.getDataHolder().setHoldingRegisters(hr);
            slave.setServerAddress(1);
            /*
             * using master-branch it should be #slave.open();
             */
            slave.listen();

            /*
             * since 1.2.8
             */
            if (slave.isListening()) {
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    @Override
                    public void run() {
                        synchronized (slave) {
                            slave.notifyAll();
                        }
                    }
                });

                synchronized (slave) {
                    slave.wait();
                }

                /*
                 * using master-branch it should be #slave.close();
                 */
                slave.shutdown();
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IllegalDataValueException e) {
            throw new RuntimeException(e);
        } catch (IllegalDataAddressException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ModbusIOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class MyOwnDataHolder extends DataHolder {

        final List<JlibmodbusEventListener> jlibmodbusEventListenerList = new ArrayList<JlibmodbusEventListener>();

        public MyOwnDataHolder() {
            // you can place the initialization code here
            /*
            something like that:
            setHoldingRegisters(new SimpleHoldingRegisters(10));
            setCoils(new Coils(128));
            ...
            etc.
             */
        }

        public void addEventListener(JlibmodbusEventListener listener) {
            jlibmodbusEventListenerList.add(listener);
        }

        public boolean removeEventListener(JlibmodbusEventListener listener) {
            return jlibmodbusEventListenerList.remove(listener);
        }

        @Override
        public void writeHoldingRegister(int offset, int value) throws IllegalDataAddressException, IllegalDataValueException {
            for (JlibmodbusEventListener l : jlibmodbusEventListenerList) {
                l.onWriteToSingleHoldingRegister(offset, value);
            }
            super.writeHoldingRegister(offset, value);
        }

        @Override
        public void writeHoldingRegisterRange(int offset, int[] range) throws IllegalDataAddressException, IllegalDataValueException {
            for (JlibmodbusEventListener l : jlibmodbusEventListenerList) {
                l.onWriteToMultipleHoldingRegisters(offset, range.length, range);
            }
            super.writeHoldingRegisterRange(offset, range);
        }

        @Override
        public void writeCoil(int offset, boolean value) throws IllegalDataAddressException, IllegalDataValueException {
            for (JlibmodbusEventListener l : jlibmodbusEventListenerList) {
                l.onWriteToSingleCoil(offset, value);
            }
            super.writeCoil(offset, value);
        }

        @Override
        public void writeCoilRange(int offset, boolean[] range) throws IllegalDataAddressException, IllegalDataValueException {
            for (JlibmodbusEventListener l : jlibmodbusEventListenerList) {
                l.onWriteToMultipleCoils(offset, range.length, range);
            }
            super.writeCoilRange(offset, range);
        }
    }
}
