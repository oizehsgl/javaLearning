package org.oizehsgl.javaLearning.library.mirai.config;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.auth.BotAuthorization;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.utils.BotConfiguration;
import org.oizehsgl.javaLearning.library.mirai.consumer.EncyclopediaConsumer;
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
    @Bean("qrCodeBot")
    public Bot bot() {
        Bot bot = BotFactory.INSTANCE.newBot(1874637099, BotAuthorization.byQRCode());
        BotConfiguration botConfiguration = bot.getConfiguration();
        // 切换登录协议
        botConfiguration.setProtocol(BotConfiguration.MiraiProtocol.ANDROID_WATCH);
        //// 切换心跳策略
        //botConfiguration.setHeartbeatStrategy(BotConfiguration.HeartbeatStrategy.REGISTER);
        //// 验证码登录处理器
        //botConfiguration.setLoginSolver(new YourLoginSolver());
        // 修改缓存目录
        botConfiguration.setCacheDir(new File("/tmp/mirai"));
        // 存储设备信息
        botConfiguration.fileBasedDeviceInfo("device.json");
        // 设置事件监听回调
        // TODO: 后期改为注册事件,可以控制事件的开关
        Listener<GroupMessageEvent> listener = bot.getEventChannel()
                .subscribeAlways(GroupMessageEvent.class, EncyclopediaConsumer.builder().build());
        return bot;
    }
}
