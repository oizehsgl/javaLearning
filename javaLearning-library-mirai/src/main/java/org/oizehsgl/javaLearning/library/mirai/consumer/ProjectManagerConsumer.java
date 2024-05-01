package org.oizehsgl.javaLearning.library.mirai.consumer;

import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import org.oizehsgl.javaLearning.library.mirai.constant.ProjectConstant;
import org.oizehsgl.javaLearning.library.mirai.enums.ProjectEnum;
import org.oizehsgl.javaLearning.library.mirai.property.ProjectProperties;
import org.oizehsgl.javaLearning.library.mirai.service.ProjectService;
import org.oizehsgl.javaLearning.library.mirai.util.ProjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author yueyuanzhi
 */
@Getter
@Setter
@Component
public class ProjectManagerConsumer extends ProjectConsumer {
    @Resource
    private ProjectService projectService;
    @Resource
    private ProjectProperties projectProperties;

    private Boolean projectConsumerSwitch;
    private final Map<String, Consumer<GroupMessageEvent>> consumerMap = new HashMap<>();

    @Override
    public void init() {
        consumerMap.put("。帮助", getHelpConsumer());
        consumerMap.put("。列表", getListConsumer());
        consumerMap.put("。启动", getOpenOrCloseConsumer(projectService::on, "启动"));
        consumerMap.put("。关闭", getOpenOrCloseConsumer(projectService::off, "关闭"));
    }

    private Consumer<GroupMessageEvent> getListConsumer() {
        return groupMessageEvent -> {
            MessageChainBuilder messageChainBuilder = new MessageChainBuilder();
            Map<String, ProjectConsumer> projectConsumerMap = projectService.getProjectConsumerMap();
            Optional.ofNullable(projectConsumerMap).orElse(Collections.emptyMap())
                    .values()
                    .stream()
                    .map(Object::getClass)
                    .map(Class::getSimpleName)
                    .map(StringUtils::uncapitalize)
                    .map(s -> ProjectEnum.getEnumByFun(ProjectEnum::getBeanName, s))
                    .forEach(pe -> messageChainBuilder.append(pe.getName())
                            .append("-")
                            .append(projectService.onOrOff(pe) ? "启动" : "关闭")
                            .append("中")
                            .append(ProjectConstant.LINE_SEPARATOR));
            groupMessageEvent.getSubject().sendMessage(messageChainBuilder.build());
        };
    }

    private Consumer<GroupMessageEvent> getHelpConsumer() {
        return groupMessageEvent -> {
            MessageChainBuilder messageChainBuilder = new MessageChainBuilder();
            int index = 0;
            for (String s : consumerMap.keySet()) {
                if (index++ != 0) {
                    messageChainBuilder.append(ProjectConstant.LINE_SEPARATOR);
                }
                messageChainBuilder.append(s);
            }
            groupMessageEvent.getSubject().sendMessage(messageChainBuilder.build());
        };
    }

    private Consumer<GroupMessageEvent> getOpenOrCloseConsumer(Consumer<ProjectEnum> consumer, String desc) {
        return groupMessageEvent -> {
            String projectName = ProjectUtils.getParam(groupMessageEvent);
            ProjectEnum projectEnum = ProjectEnum.getEnumByFun(ProjectEnum::getName, projectName);
            if (Objects.isNull(projectEnum)) {
                groupMessageEvent.getSubject().sendMessage(new MessageChainBuilder()
                        .append("项目不存在")
                        .build());
                return;
            }
            if (ProjectEnum.PROJECT_MANAGEMENT.equals(projectEnum)) {
                groupMessageEvent.getSubject().sendMessage(new MessageChainBuilder()
                        .append("项目管理不可").append(desc)
                        .build());
                return;
            }
            consumer.accept(projectEnum);
            groupMessageEvent.getSubject().sendMessage(new MessageChainBuilder()
                    .append(projectName)
                    .append("已经")
                    .append(desc)
                    .build());
        };
    }
}
