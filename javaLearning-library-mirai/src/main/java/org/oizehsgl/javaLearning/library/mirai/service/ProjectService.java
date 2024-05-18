package org.oizehsgl.javaLearning.library.mirai.service;

import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.oizehsgl.javaLearning.library.mirai.consumer.ProjectConsumer;
import org.oizehsgl.javaLearning.library.mirai.enums.ProjectEnum;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * 项目 服务层
 *
 * @author oizehsgl
 */
@Service
@RequiredArgsConstructor
public class ProjectService {
    private final Bot bot;
    @Lazy
    @Resource
    @Getter
    private Map<String, ProjectConsumer> projectConsumerMap;

    public void start() {
        for (Map.Entry<String, ProjectConsumer> stringProjectConsumerEntry : projectConsumerMap.entrySet()) {
            String beanName = stringProjectConsumerEntry.getKey();
            ProjectConsumer projectConsumer = stringProjectConsumerEntry.getValue();
            // 初始化
            projectConsumer.init();
            // 注册监听
            Listener<GroupMessageEvent> listener = bot.getEventChannel()
                    .subscribeAlways(GroupMessageEvent.class, projectConsumer);
            // 关闭监听(listener.complete()关闭后无法启动,需要换一个方法)
            //listener.complete();
            this.off(ProjectEnum.getEnumByFun(ProjectEnum::getBeanName, beanName));

        }
        // 启动项目管理
        //this.on(ProjectEnum.PROJECT_MANAGEMENT);
    }

    public void on(ProjectEnum projectEnum) {
        toggle(projectEnum, Boolean.TRUE);
    }

    public void off(ProjectEnum projectEnum) {
        toggle(projectEnum, Boolean.FALSE);
    }

    public Boolean onOrOff(ProjectEnum projectEnum) {
        return getProjectConsumer(projectEnum)
                .map(ProjectConsumer::getProjectConsumerSwitch)
                .orElse(null);
    }

    public void toggle(ProjectEnum projectEnum, Boolean bool) {
        getProjectConsumer(projectEnum)
                .ifPresent(p -> p.setProjectConsumerSwitch(bool));
    }

    public Optional<ProjectConsumer> getProjectConsumer(String beanName) {
        return Optional.ofNullable(projectConsumerMap.get(beanName));
    }

    public Optional<ProjectConsumer> getProjectConsumer(ProjectEnum projectEnum) {
        return getProjectConsumer(projectEnum.getBeanName());
    }
}
