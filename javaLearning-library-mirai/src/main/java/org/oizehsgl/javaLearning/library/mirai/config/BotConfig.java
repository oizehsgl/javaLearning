package org.oizehsgl.javaLearning.library.mirai.config;

import jakarta.annotation.Resource;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.auth.BotAuthorization;
import net.mamoe.mirai.utils.BotConfiguration;
import org.oizehsgl.javaLearning.library.mirai.property.ProjectProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * 示例机器人
 *
 * @author yueyuanzhi
 */
@Configuration
public class BotConfig {
    @Resource
    private ProjectProperties projectProperties;

    @Bean("qrCodeBot")
    public Bot bot() {
        Bot bot = BotFactory.INSTANCE.newBot(projectProperties.getRobotId(), BotAuthorization.byQRCode());
        //Bot bot = BotFactory.INSTANCE.newBot(1874637099, BotAuthorization.byPassword("O_2wmj7ddnxk"));
        //Bot bot1 =MockBotFactory.newMockBotBuilder();
        BotConfiguration botConfiguration = bot.getConfiguration();
        // 切换登录协议
        botConfiguration.setProtocol(BotConfiguration.MiraiProtocol.ANDROID_WATCH);
        //botConfiguration.setProtocol(BotConfiguration.MiraiProtocol.ANDROID_PHONE);
        //// 切换心跳策略
        //botConfiguration.setHeartbeatStrategy(BotConfiguration.HeartbeatStrategy.REGISTER);
        //// 验证码登录处理器
        //botConfiguration.setLoginSolver(new YourLoginSolver());
        // 修改缓存目录
        botConfiguration.setCacheDir(new File("/tmp/mirai/cache"));
        // 存储设备信息
        botConfiguration.fileBasedDeviceInfo("/tmp/mirai/device.json");
        // 机器人登录
        bot.login();
        return bot;
    }
}
