package org.oizehsgl.sub;

import java.util.Date;

/**
 * chatRoom
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class ChatRoom {
    public static void showMessage(User user,String message) {
        System.out.printf("%s--%s: %s%n",new Date(),user.getName(),message);
    }
}
