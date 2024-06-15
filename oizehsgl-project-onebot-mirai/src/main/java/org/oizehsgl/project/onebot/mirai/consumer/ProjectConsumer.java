package org.oizehsgl.project.onebot.mirai.consumer;

import lombok.Setter;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.At;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.PlainText;
import net.mamoe.mirai.message.data.SingleMessage;
import org.apache.commons.lang3.function.Consumers;
import org.oizehsgl.project.onebot.mirai.property.ProjectProperties;
import org.oizehsgl.project.onebot.mirai.util.ProjectUtils;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * 项目消费者接口
 *
 * @author oizehsgl
 */
public abstract class ProjectConsumer implements Consumer<GroupMessageEvent> {
  @Setter public Consumer<GroupMessageEvent> defaultConsumer = Consumers.nop();

  public abstract ProjectProperties getProjectProperties();

  public abstract Map<String, Consumer<GroupMessageEvent>> getConsumerMap();

  public abstract Boolean getProjectConsumerSwitch();

  public abstract void setProjectConsumerSwitch(Boolean bool);

  @Override
  public void accept(GroupMessageEvent groupMessageEvent) {
    // 如果开关没有打开直接返回
    if (!Boolean.TRUE.equals(getProjectConsumerSwitch())) {
      return;
    }
    // 获取事件发生的群号
    Long groupId = groupMessageEvent.getGroup().getId();
    if (Objects.equals(getProjectProperties().getGroupId(), groupId)) {
      // 获取事件发送者qq号
      // Long senderId = groupMessageEvent.getSender().getId();
      // 收到的消息
      MessageChain messageChain = groupMessageEvent.getMessage();
      // 获取第一个消息
      SingleMessage firstSingleMessage = messageChain.get(1);
      // 只有第一个消息@机器人时才会解析指令
      if (firstSingleMessage.equals(new At(getProjectProperties().getRobotId()))) {
        // 执行命令逻辑
        SingleMessage secondSingleMessage = messageChain.get(2);
        // 只有第二个消息为文本才会解析
        if (secondSingleMessage instanceof PlainText) {
          String cmd = ProjectUtils.getCmd(groupMessageEvent);
          Optional.ofNullable(getConsumerMap().get(cmd))
              .ifPresent(c -> c.accept(groupMessageEvent));

          // 执行默认逻辑
          defaultConsumer.accept(groupMessageEvent);
        }
      }
    }
  }

  public abstract void init();
}
