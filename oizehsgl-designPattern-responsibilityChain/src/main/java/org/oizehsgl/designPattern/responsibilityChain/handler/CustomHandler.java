package org.oizehsgl.designPattern.responsibilityChain.handler;


/**
 * @author oizehsgl
 */
public interface CustomHandler<T, R> {
  R handle(T t);
}
