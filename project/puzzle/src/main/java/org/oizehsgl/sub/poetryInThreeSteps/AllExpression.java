package org.oizehsgl.sub.poetryInThreeSteps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * allExpression
 *
 * @author oizehsgl
 * @since 4/12/23
 */
public class AllExpression {
    /**
     * 存放成对的表情衍生的单词以及汉字拼音
     */
    static Map<Integer, Set<String>> map = new HashMap<>() {{
//        put(1, Stream.of(
//                "why","how", "question", "unknown", "problem", "interrogation", "query", "doubt", "疑", "惑", "谜", "问", "猜","何"
//        ).collect(Collectors.toSet()));
//        put(2, Stream.of(
//                "eye", "see", "look", "watch", "view", "sight", "看", "观", "望", "瞧", "赏","瞄","视","窥","瞥", "眼", "眸", "目", "睛","瞟","盯"
//        ).collect(Collectors.toSet()));
//        put(3, Stream.of(
//                "ghost", "spirit","fetch","soul","spectre","anima","atman", "鬼", "灵","怪"
//        ).collect(Collectors.toSet()));
//        put(4, Stream.of(
//                "car", "vehicle","rook","lathe","castle", "车"
//        ).collect(Collectors.toSet()));
//        put(5, Stream.of(
//                "silence","tranquil", "mum","mute","quite", "寥", "谧", "嘘", "默", "噤", "缄", "静", "寂"
//        ).collect(Collectors.toSet()));
//        put(6, Stream.of(
//                "embrace", "hug", "enfold","infold","hold","surround","caress", "拥", "抱","搂"
//        ).collect(Collectors.toSet()));
//        put(7, Stream.of(
//                "gun", "rifle", "firearm","blunderbuss","pistol","peacemaker", "枪", "毙","铳","杀"
//        ).collect(Collectors.toSet()));

        put(1, Stream.of(
                "bu"
        ).collect(Collectors.toSet()));
        put(2, Stream.of(
                "jin"
        ).collect(Collectors.toSet()));
        put(3, Stream.of(
                "chang"
        ).collect(Collectors.toSet()));
        put(4, Stream.of(
                "jiang"
        ).collect(Collectors.toSet()));
        put(5, Stream.of(
                "gun"
        ).collect(Collectors.toSet()));
        put(6, Stream.of(
                "gun"
        ).collect(Collectors.toSet()));
        put(7, Stream.of(
                "lai"
        ).collect(Collectors.toSet()));
    }};
}