package org.oizehsgl.javaLearning.library.mirai.consumer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import org.oizehsgl.javaLearning.library.mirai.listener.ProjectConsumerListener;
import org.oizehsgl.javaLearning.library.mirai.property.ProjectProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author yueyuanzhi
 */
@Getter
@Component
@RequiredArgsConstructor
public class ProjectManagerConsumer extends ProjectConsumer {
    private final ProjectConsumerListener projectConsumerListener;
    private final ProjectProperties projectProperties;
    @Setter
    private Boolean switchOn;
    private final Map<String, Consumer<GroupMessageEvent>> consumerMap = new HashMap<>() {{
        put("项目管理 帮助", groupMessageEvent -> {
            MessageChainBuilder messageChainBuilder = new MessageChainBuilder();
            for (String s : consumerMap.keySet()) {
                messageChainBuilder.append(s);
            }
            groupMessageEvent.getSubject().sendMessage(messageChainBuilder.build());
        });

    }};
}
