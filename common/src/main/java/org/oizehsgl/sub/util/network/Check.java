package org.oizehsgl.sub.util.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 校验
 *
 * @author oizehsgl
 * @since 2023/1/9
 */
public class Check {
    public static void main(String[] args) {
        if (checkIp(args[0])) {
            System.out.println("Ip可以使用");
        } else {
            System.out.println("Ip不可用");
        }
        if (checkIpPort(args[0], Integer.parseInt(args[1]))) {
            System.out.println("地址和端口号可用");
        } else {
            System.out.println("地址和端口号不可用");
        }
    }

    /**
     * 检测Ip和端口是否可用
     *
     * @param ip
     * @param port
     * @return
     */
    public static boolean checkIpPort(String ip, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(ip, port), 3000);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("socket关闭失败");
                }
            }
        }

    }

    /**
     * 检测Ip地址
     *
     * @param ip
     * @return
     */
    public static boolean checkIp(String ip) {
        try {
            return InetAddress.getByName(ip).isReachable(3000);
        } catch (IOException e) {
            return false;
        }
    }
}
