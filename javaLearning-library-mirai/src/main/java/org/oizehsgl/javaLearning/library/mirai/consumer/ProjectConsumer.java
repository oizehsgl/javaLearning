package org.oizehsgl.javaLearning.library.mirai.consumer;

import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.At;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.SingleMessage;
import org.oizehsgl.javaLearning.library.mirai.property.ProjectProperties;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * 项目消费者接口
 *
 * @author yueyuanzhi
 */
public abstract class ProjectConsumer implements Consumer<GroupMessageEvent> {
    public abstract ProjectProperties getProjectProperties();

    public abstract Map<String, Consumer<GroupMessageEvent>> getConsumerMap();

    public abstract Boolean getSwitchOn();
    public abstract void setSwitchOn(Boolean bool);


    @Override
    public void accept(GroupMessageEvent groupMessageEvent) {
        // 如果开关没有打开直接返回
        if (!Boolean.TRUE.equals(getSwitchOn())) {
            return;
        }
        // 获取事件发生的群号
        Long groupId = groupMessageEvent.getGroup().getId();
        if (Objects.equals(getProjectProperties().getGroupId(), groupId)) {
            // 获取事件发送者qq号
            //Long senderId = groupMessageEvent.getSender().getId();
            // 收到的消息
            MessageChain messageChain = groupMessageEvent.getMessage();
            // 获取第一个消息
            SingleMessage firstSingleMessage = messageChain.get(1);
            // 只有第一个消息@机器人时才会解析指令
            if (firstSingleMessage.equals(new At(getProjectProperties().getRobotId()))) {
                SingleMessage secondSingleMessage = messageChain.get(2);
                Optional.ofNullable(getConsumerMap().get(secondSingleMessage.contentToString().trim()))
                        .ifPresent(c -> c.accept(groupMessageEvent));
            }
        }
    }
}
