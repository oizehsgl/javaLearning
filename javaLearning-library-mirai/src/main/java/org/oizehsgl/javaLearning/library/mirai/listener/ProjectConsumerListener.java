package org.oizehsgl.javaLearning.library.mirai.listener;

import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.oizehsgl.javaLearning.library.mirai.enums.ProjectEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 项目消费者监听
 *
 * @author yueyuanzhi
 */
@Component
public class ProjectConsumerListener {
    private final Map<String, Listener<GroupMessageEvent>> listenerMap = new HashMap<>();

    public void register(String beanName, Listener<GroupMessageEvent> listener) {
        listenerMap.put(beanName, listener);
    }

    public void on(ProjectEnum projectEnum) {
        Optional.ofNullable(listenerMap.get(projectEnum.getBeanName())).ifPresent(Listener::start);
    }

    public void off(ProjectEnum projectEnum) {
        Optional.ofNullable(listenerMap.get(projectEnum.getBeanName())).ifPresent(Listener::complete);
    }
}
