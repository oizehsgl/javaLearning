package org.oizehsgl.sub;

/**
 * nilCustomer
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class NilCustomer extends AbstractCustomer{

   @Override
   public String getName() {
      return "Not Available in Customer Database";
   }

   @Override
   public boolean isNil() {
      return true;
   }
}
