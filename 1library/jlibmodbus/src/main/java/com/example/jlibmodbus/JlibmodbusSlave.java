package com.example.jlibmodbus;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.data.ModbusHoldingRegisters;
import com.intelligt.modbus.jlibmodbus.exception.*;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.msg.request.ReadHoldingRegistersRequest;
import com.intelligt.modbus.jlibmodbus.msg.response.ReadHoldingRegistersResponse;
import com.intelligt.modbus.jlibmodbus.slave.ModbusSlaveFactory;
import com.intelligt.modbus.jlibmodbus.slave.ModbusSlaveTCP;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import com.intelligt.modbus.jlibmodbus.utils.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Observer;

/**
 * @author oizehsgl
 * @since 7/11/23
 */
@Service
public class JlibmodbusSlave implements CommandLineRunner {

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        try {
            Modbus.setLogLevel(Modbus.LogLevel.LEVEL_DEBUG);
            TcpParameters tcpParameters = new TcpParameters();
            //listening on localhost
            tcpParameters.setHost(InetAddress.getLocalHost());
            tcpParameters.setPort(Modbus.TCP_PORT + 1000);
            tcpParameters.setKeepAlive(true);

            ModbusSlaveTCP slave = (ModbusSlaveTCP) ModbusSlaveFactory.createModbusSlaveTCP(tcpParameters);
            ModbusMaster master = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);

            master.setResponseTimeout(1000);
            slave.setServerAddress(Modbus.TCP_DEFAULT_ID);
            slave.setBroadcastEnabled(true);
            slave.setReadTimeout(1000);


            FrameEventListener listener = new FrameEventListener() {
                @Override
                public void frameSentEvent(FrameEvent event) {
                    System.out.println("frame sent " + DataUtils.toAscii(event.getBytes()));
                }

                @Override
                public void frameReceivedEvent(FrameEvent event) {
                    System.out.println("frame recv " + DataUtils.toAscii(event.getBytes()));
                }
            };


            master.addListener(listener);
            slave.addListener(listener);
            Observer o = new ModbusSlaveTcpObserver() {
                @Override
                public void clientAccepted(TcpClientInfo info) {
                    System.out.println("Client connected " + info.getTcpParameters().getHost());
                }

                @Override
                public void clientDisconnected(TcpClientInfo info) {
                    System.out.println("Client disconnected " + info.getTcpParameters().getHost());
                }
            };
            slave.addObserver(o);

            ModbusHoldingRegisters holdingRegisters = new ModbusHoldingRegisters(1000);

            for (int i = 0; i < holdingRegisters.getQuantity(); i++) {
                //fill
                holdingRegisters.set(i, i + 1);
            }


            //place the number PI at offset 0
            holdingRegisters.setFloat64At(0, Math.PI);

            slave.getDataHolder().setHoldingRegisters(holdingRegisters);

            Modbus.setAutoIncrementTransactionId(true);

            slave.listen();

            master.connect();

            //prepare request
            ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest();
            request.setServerAddress(Modbus.TCP_DEFAULT_ID);
            request.setStartAddress(0);
            request.setQuantity(10);
            ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) request.getResponse();

            master.processRequest(request);
            ModbusHoldingRegisters registers = response.getHoldingRegisters();
            for (int r : registers) {
                System.out.println(r);
            }
            //get float
            System.out.println("PI is approximately equal to " + registers.getFloat64At(0));
            System.out.println();

            master.disconnect();
            slave.shutdown();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IllegalDataValueException e) {
            throw new RuntimeException(e);
        } catch (IllegalDataAddressException e) {
            throw new RuntimeException(e);
        } catch (ModbusProtocolException e) {
            throw new RuntimeException(e);
        } catch (ModbusNumberException e) {
            throw new RuntimeException(e);
        } catch (ModbusIOException e) {
            throw new RuntimeException(e);
        }
    }
}
