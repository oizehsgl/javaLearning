package org.oizehsgl.project.onebot.mirai.consumer;

import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.contact.Member;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.At;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.PlainText;
import org.oizehsgl.project.onebot.mirai.constant.ProjectConstant;
import org.oizehsgl.project.onebot.mirai.model.QuestionAnswerBo;
import org.oizehsgl.project.onebot.mirai.property.ProjectProperties;
import org.oizehsgl.project.onebot.mirai.util.ProjectUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author oizehsgl
 */
@Slf4j
@Getter
@Setter
@Component
public class EncyclopediaConsumer extends ProjectConsumer {
  private final Map<String, Consumer<GroupMessageEvent>> consumerMap = new HashMap<>();
  private final List<QuestionAnswerBo> questionAnswerBoList = new ArrayList<>();
  @Resource private ProjectProperties projectProperties;
  // 必需属性
  private Boolean projectConsumerSwitch;
  // 项目属性
  private Boolean start;
  private Integer index;
  private String projectDir = "/home/oizehsgl/Downloads/test/";

  private Map<Member, Integer> rankMap = new HashMap<>();

  @Override
  public void init() {
    consumerMap.put("开始", getStartConsumer());
    consumerMap.put("出题", getNextConsumer());
    consumerMap.put("修正", getCorrectCOnsumer());
    consumerMap.put("排名", getRankConsumer());
  }

  private Consumer<GroupMessageEvent> getStartConsumer() {
    // 初始化索引
    index = 0;
    return GroupMessageEvent -> {};
  }

  private Consumer<GroupMessageEvent> getNextConsumer() {
    log.info("出题开始");
    return groupMessageEventTmp -> {
      log.info("出题开始,执行函数");
      index++;

      QuestionAnswerBo questionAnswerBo = null;
      try {
        questionAnswerBo = QuestionAnswerBo.builder().build().load(projectDir + index);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      QuestionAnswerBo finalQuestionAnswerBo = questionAnswerBo;

      groupMessageEventTmp
          .getSubject()
          .sendMessage(
              new MessageChainBuilder()
                  .append(
                      ProjectUtils.buildMessage(
                          groupMessageEventTmp.getGroup(),
                          questionAnswerBo.getFilePathList().get(0)))
                  .build());

      Consumer<GroupMessageEvent> groupMessageEventConsumer =
          groupMessageEvent -> {
            String s = groupMessageEvent.getMessage().get(2).contentToString().trim();
            Map<String, Integer> answerScoreMap = finalQuestionAnswerBo.getAnswerScoreMap();
            if (answerScoreMap.containsKey(s)) {
              Member member = groupMessageEvent.getSender();
              Integer score = rankMap.getOrDefault(member, 0);
              score = score + answerScoreMap.get(s);
              rankMap.put(member, score);
            }
          };
      setDefaultConsumer(groupMessageEventConsumer);
    };
  }

  private Consumer<GroupMessageEvent> getCorrectCOnsumer() {
    return GroupMessageEvent -> {};
  }

  private Consumer<GroupMessageEvent> getRankConsumer() {
    return GroupMessageEvent -> {
      MessageChainBuilder messageChainBuilder = new MessageChainBuilder();
      for (Map.Entry<Member, Integer> entry : rankMap.entrySet()) {
        messageChainBuilder
            .append(new At(entry.getKey().getId()))
            .append("   ")
            .append(
                new PlainText(
                    Optional.ofNullable(entry.getValue()).map(String::valueOf).orElse("0")))
            .append(ProjectConstant.LINE_SEPARATOR);
      }
      GroupMessageEvent.getSubject().sendMessage(messageChainBuilder.build());
    };
  }

  private QuestionAnswerBo loadQuestionAnswerBo() {
    return null;
  }

  public Consumer<GroupMessageEvent> getConsumer(int index) {

    return null;
  }
}
