package org.oizehsgl.javaLearning.library.mirai;

import jakarta.annotation.Resource;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.QuoteReply;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaLearningLibraryMiraiApplicationTests {

  @Resource private Bot qrCodeBot;

  public static void afterLogin(Bot bot) {
    long yourQQNumber = 3423501402L;
    bot.getNick();
    bot.getEventChannel()
        .subscribeAlways(
            FriendMessageEvent.class,
            (event) -> {
              if (event.getSender().getId() == yourQQNumber) {
                event
                    .getSubject()
                    .sendMessage(
                        new MessageChainBuilder()
                            .append(new QuoteReply(event.getMessage()))
                            .append("Hi, you just said: '")
                            .append(event.getMessage())
                            .append("'")
                            .build());
              }
            });
  }

  @Test
  void contextLoads() {
    qrCodeBot.login();
    System.out.println(qrCodeBot.getFriends());
  }
}
