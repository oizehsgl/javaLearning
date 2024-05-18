package org.oizehsgl.javaLearning.library.mirai;

import jakarta.annotation.Resource;
import net.mamoe.mirai.Bot;

/**
 * 登录
 *
 * @author oizehsgl
 */
public class Login {
    @Resource
    private Bot qrCodeBot;

    public Bot loginWithPassword() {
        //// 使用密码登录
        //Bot bot = BotFactory.INSTANCE.newBot(qq, password, new BotConfiguration() {{
        //    // 配置，例如：
        //    fileBasedDeviceInfo();
        //}});
        return null;
    }
    public Bot loginWithQrCode() {
        qrCodeBot.login();
        return qrCodeBot;
    }


    public static void main(String[] args) {
        //
        //Bot bot = BotFactory.INSTANCE.newBot(qq, password, configuration -> {
        //});
        // 在 2.15.0 中加入, 使用二维码登录
    }
}
