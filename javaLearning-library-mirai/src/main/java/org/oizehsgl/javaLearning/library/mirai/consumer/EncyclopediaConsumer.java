package org.oizehsgl.javaLearning.library.mirai.consumer;

import lombok.Builder;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;

import java.util.function.Consumer;

/**
 * @author yueyuanzhi
 */
@Builder
public class EncyclopediaConsumer implements Consumer<GroupMessageEvent> {

    @Override
    public void accept(GroupMessageEvent groupMessageEvent) {
        if (groupMessageEvent.getGroup().getId() == 634466080L &&
                groupMessageEvent.getSender().getId() == 3423501402L) {
            // 收到的消息
            MessageChain messageChain = groupMessageEvent.getMessage();
            MessageContent at = messageChain.get(At.Key);
            System.out.println(at.contentToString());
            QuoteReply quoteReply = messageChain.get(QuoteReply.Key);
            SingleMessage firstSingleMessage = messageChain.get(1);
            System.out.println(firstSingleMessage);
            System.out.println(firstSingleMessage.equals(new At(1874637099)));
            System.out.println(firstSingleMessage.contentToString());
            for (SingleMessage singleMessage : groupMessageEvent.getMessage()) {

            }
            groupMessageEvent.getSubject().sendMessage(new MessageChainBuilder()
                    .append(new QuoteReply(groupMessageEvent.getMessage()))
                    .append(new PlainText("Hi, you just said:---- '"))
                    .append(groupMessageEvent.getMessage())
                    .append(new PlainText("'"))
                    .append(Image.fromId("{f8f1ab55-bf8e-4236-b55e-955848d7069f}.png"))
                    .build()
            );
        }
    }
}
