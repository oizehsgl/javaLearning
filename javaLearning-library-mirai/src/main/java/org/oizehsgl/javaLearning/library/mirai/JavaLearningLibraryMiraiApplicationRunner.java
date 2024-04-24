package org.oizehsgl.javaLearning.library.mirai;

import jakarta.annotation.Resource;
import net.mamoe.mirai.Bot;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class JavaLearningLibraryMiraiApplicationRunner implements ApplicationRunner {
    @Resource
    private Bot bot;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        bot.login();
    }
}
