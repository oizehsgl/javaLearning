package org.oizehsgl.sub;

/**
 * user
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class User {
   private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
