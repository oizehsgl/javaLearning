package org.oizehsgl.javaLearning.library.mirai.consumer;

import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.oizehsgl.javaLearning.library.mirai.model.QuestionAnswerBo;
import org.oizehsgl.javaLearning.library.mirai.property.ProjectProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author yueyuanzhi
 */
@Getter
@Setter
@Component
public class EncyclopediaConsumer extends ProjectConsumer {
    @Resource
    private ProjectProperties projectProperties;
    // 必需属性
    private Boolean projectConsumerSwitch;
    private final Map<String, Consumer<GroupMessageEvent>> consumerMap = new HashMap<>();
    // 项目属性
    private Boolean start;
    private final List<QuestionAnswerBo> questionAnswerBoList = new ArrayList<>();
    private Integer index;

    @Override
    public void init() {
        consumerMap.put("开始", getStartConsumer());
        consumerMap.put("下一题", getNextConsumer());
        consumerMap.put("修正", getCorrectCOnsumer());
        consumerMap.put("排名", getRankConsumer());
    }

    public void initQuestionAnswerList() {
        questionAnswerBoList.add(QuestionAnswerBo.builder()
                .filePathList(new ArrayList<>() {{
                    add("");
                }})
                .answerScoreMap(new HashMap<>() {{
                    put("a", 1);
                    put("b", 2);
                }})
                .build());
    }

    private Consumer<GroupMessageEvent> getStartConsumer() {
        // 初始化索引
        index=0;
        return GroupMessageEvent -> {
        };
    }

    private Consumer<GroupMessageEvent> getNextConsumer() {
        return GroupMessageEvent -> {
        };
    }

    private Consumer<GroupMessageEvent> getCorrectCOnsumer() {
        return GroupMessageEvent -> {
        };
    }

    private Consumer<GroupMessageEvent> getRankConsumer() {
        return GroupMessageEvent -> {
        };
    }

    private QuestionAnswerBo loadQuestionAnswerBo(){
        return null;
    }
}
