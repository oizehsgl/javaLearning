package org.oizehsgl.javaLearning.library.mirai.util;

import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.Message;
import org.oizehsgl.javaLearning.library.mirai.constant.ProjectConstant;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * 群消息工具类
 *
 * @author yueyuanzhi
 */
public class ProjectUtils {
    public static String getParam(GroupMessageEvent groupMessageEvent) {
        return get(groupMessageEvent, s -> {
            int delimiterIndex = s.indexOf(ProjectConstant.CMD_AND_PARAM_DELIMITER_CHAR);
            if (Objects.equals(delimiterIndex, -1)) {
                return "";
            } else {
                return s.substring(delimiterIndex + 1);
            }
        });
    }

    public static String getCmd(GroupMessageEvent groupMessageEvent) {
        return get(groupMessageEvent, s -> {
            int delimiterIndex = s.indexOf(ProjectConstant.CMD_AND_PARAM_DELIMITER_CHAR);
            if (Objects.equals(delimiterIndex, -1)) {
                return s;
            } else {
                return s.substring(0, delimiterIndex);
            }
        });
    }

    public static String get(GroupMessageEvent groupMessageEvent, Function<String, String> function) {
        return Optional.ofNullable(groupMessageEvent)
                .map(GroupMessageEvent::getMessage)
                .map(mc -> mc.get(2))
                .map(Message::contentToString)
                .map(String::trim)
                .map(function)
                .orElse("");
    }
}
