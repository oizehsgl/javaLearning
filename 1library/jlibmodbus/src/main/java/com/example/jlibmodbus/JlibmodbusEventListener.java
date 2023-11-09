package com.example.jlibmodbus;

/**
 * @author oizehsgl
 * @since 7/11/23
 */
public interface JlibmodbusEventListener {

    void onWriteToSingleCoil(int address, boolean value);

    void onWriteToMultipleCoils(int address, int quantity, boolean[] values);

    void onWriteToSingleHoldingRegister(int address, int value);

    void onWriteToMultipleHoldingRegisters(int address, int quantity, int[] values);
}
