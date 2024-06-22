package org.oizehsgl.designPattern.responsibilityChain.handler;


/**
 * @author oizehsgl
 */
public class CustomFirstHandler  implements CustomHandler<String, Integer> {

  @Override
  public Integer handle(String s) {
    return 0;
  }
}
