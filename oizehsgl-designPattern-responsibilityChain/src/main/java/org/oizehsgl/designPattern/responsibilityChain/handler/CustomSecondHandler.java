package org.oizehsgl.designPattern.responsibilityChain.handler;


/**
 * @author oizehsgl
 */
public class CustomSecondHandler implements CustomHandler<Integer,String> {

  @Override
  public String handle(Integer integer) {
    return "";
  }
}
