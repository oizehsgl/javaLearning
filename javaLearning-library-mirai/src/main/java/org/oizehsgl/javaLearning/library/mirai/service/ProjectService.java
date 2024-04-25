package org.oizehsgl.javaLearning.library.mirai.service;

import lombok.RequiredArgsConstructor;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.oizehsgl.javaLearning.library.mirai.consumer.ProjectConsumer;
import org.oizehsgl.javaLearning.library.mirai.enums.ProjectEnum;
import org.oizehsgl.javaLearning.library.mirai.listener.ProjectConsumerListener;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * 项目 服务层
 *
 * @author yueyuanzhi
 */
@Service
@RequiredArgsConstructor
public class ProjectService {
    private final Bot bot;
    private final Map<String, ProjectConsumer> projectConsumerMap;
    private final ProjectConsumerListener projectConsumerListener;

    public void start() {
        for (Map.Entry<String, ProjectConsumer> stringProjectConsumerEntry : projectConsumerMap.entrySet()) {
            String beanName = stringProjectConsumerEntry.getKey();
            ProjectConsumer projectConsumer = stringProjectConsumerEntry.getValue();
            // 注册监听
            Listener<GroupMessageEvent> listener = bot.getEventChannel()
                    .subscribeAlways(GroupMessageEvent.class, projectConsumer);
            // 关闭监听(listener.complete()关闭后无法启动,需要换一个方法)
            //listener.complete();
            this.off(ProjectEnum.getEnum(ProjectEnum::getBeanName, beanName));
        }
        // 启动项目管理
        this.on(ProjectEnum.PROJECT_MANAGEMENT);
    }

    public void on(ProjectEnum projectEnum) {
        toggle(projectEnum, Boolean.TRUE);
    }

    public void off(ProjectEnum projectEnum) {
        toggle(projectEnum, Boolean.FALSE);
    }

    public void toggle(ProjectEnum projectEnum, Boolean bool) {
        Optional.ofNullable(projectConsumerMap.get(projectEnum.getBeanName()))
                .ifPresent(p -> p.setSwitchOn(bool));
    }
}
