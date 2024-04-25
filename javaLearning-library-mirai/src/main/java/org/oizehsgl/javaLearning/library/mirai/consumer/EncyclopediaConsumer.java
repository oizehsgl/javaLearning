package org.oizehsgl.javaLearning.library.mirai.consumer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.ExternalResource;
import org.oizehsgl.javaLearning.library.mirai.property.ProjectProperties;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author yueyuanzhi
 */
//@Component
@Getter
@RequiredArgsConstructor
public class EncyclopediaConsumer extends ProjectConsumer {
    @Setter
    private Boolean switchOn;
    private final ProjectProperties projectProperties;
    private final Map<String, Consumer<GroupMessageEvent>> consumerMap = new HashMap<>() {{
        consumerMap.put("项目管理 帮助", groupMessageEvent -> {
            MessageChainBuilder messageChainBuilder = new MessageChainBuilder();
            for (String s : consumerMap.keySet()) {
                messageChainBuilder.append(s);
            }
            groupMessageEvent.getSubject().sendMessage(messageChainBuilder.build());
        });
    }};

    @Override
    public void accept(GroupMessageEvent groupMessageEvent) {
        // 获取事件发生的群号
        Long groupId = groupMessageEvent.getGroup().getId();
        if (Objects.equals(projectProperties.getGroupId(), groupId)) {
            // 获取事件发送者qq号
            Long senderId = groupMessageEvent.getSender().getId();
            // 收到的消息
            MessageChain messageChain = groupMessageEvent.getMessage();
            MessageContent at = messageChain.get(At.Key);
            System.out.println(at.contentToString());
            QuoteReply quoteReply = messageChain.get(QuoteReply.Key);
            SingleMessage firstSingleMessage = messageChain.get(1);
            System.out.println(firstSingleMessage);
            System.out.println(firstSingleMessage.equals(new At(1874637099)));
            System.out.println(firstSingleMessage.contentToString());

            //ExternalResource.uploadAsImage(ExternalResource.create(new File("/tmp/test.png")));
            Image image = groupMessageEvent.getGroup().uploadImage(ExternalResource.create(new File("/tmp/test.png")));
            groupMessageEvent.getSubject().sendMessage(new MessageChainBuilder()
                    .append(new QuoteReply(groupMessageEvent.getMessage()))
                    .append(new PlainText("Hi, you just said:---- '"))
                    .append(groupMessageEvent.getMessage())
                    .append(new PlainText("'"))
                    .append(Image.fromId("{f8f1ab55-bf8e-4236-b55e-955848d7069f}.png"))
                    .append(image)
                    .build());
        }
    }
}
