package org.oizehsgl.javaLearning.library.mirai.config;

import jakarta.annotation.Resource;
import java.io.File;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.ExternalResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.oizehsgl.javaLearning.library.mirai.property.ProjectProperties;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class BotConfigTest {
  @Resource private Bot bot;
  @Resource private ProjectProperties projectProperties;
  private Group group;

  @BeforeEach
  public void setUp() {
    group = bot.getGroup(projectProperties.getGroupId());
  }

  @Test
  public void test() {

    //// 获取事件发送者qq号
    // Long senderId = groupMessageEvent.getSender().getId();
    //// 收到的消息
    // MessageChain messageChain = groupMessageEvent.getMessage();
    // MessageContent at = messageChain.get(At.Key);
    // System.out.println(at.contentToString());
    // QuoteReply quoteReply = messageChain.get(QuoteReply.Key);
    // SingleMessage firstSingleMessage = messageChain.get(1);
    // System.out.println(firstSingleMessage);
    // System.out.println(firstSingleMessage.equals(new At(1874637099)));
    // System.out.println(firstSingleMessage.contentToString());
    //
    //// ExternalResource.uploadAsImage(ExternalResource.create(new File("/tmp/test.png")));
    String downloadDir = "/home/oizehsgl/Downloads/";
    Image image = group.uploadImage(ExternalResource.create(new File("/tmp/test.png")));
    PlainText plainText = new PlainText("♣️");
    PlainText plainText1 = new PlainText("🎆");
    Face face = new Face(Face.牛啊);
    Audio audio = group.uploadAudio(ExternalResource.create(new File(downloadDir + "q1.mp3")));
    ShortVideo shortVideo =
        group.uploadShortVideo(
            ExternalResource.create(new File(downloadDir + "q23.jpg")),
            ExternalResource.create(new File(downloadDir + "q23.mp4")),
            "saki");

    // groupMessageEvent.getSubject().sendMessage(new MessageChainBuilder()
    //        .append(new QuoteReply(groupMessageEvent.getMessage()))
    //        .append(new PlainText("Hi, you just said:---- '"))
    //        .append(groupMessageEvent.getMessage())
    //        .append(new PlainText("'"))
    //        .append(Image.fromId("{f8f1ab55-bf8e-4236-b55e-955848d7069f}.png"))
    //        .append(image)
    //        .build());
  }
}
