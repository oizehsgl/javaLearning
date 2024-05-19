package org.oizehsgl.javaLearning.library.mirai.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import lombok.SneakyThrows;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.Message;
import net.mamoe.mirai.message.data.PlainText;
import net.mamoe.mirai.message.data.SingleMessage;
import net.mamoe.mirai.utils.ExternalResource;
import org.oizehsgl.javaLearning.library.mirai.constant.ProjectConstant;

/**
 * 群消息工具类
 *
 * @author oizehsgl
 */
public class ProjectUtils {
  public static String getParam(GroupMessageEvent groupMessageEvent) {
    return get(
        groupMessageEvent,
        s -> {
          int delimiterIndex = s.indexOf(ProjectConstant.CMD_AND_PARAM_DELIMITER_CHAR);
          if (Objects.equals(delimiterIndex, -1)) {
            return "";
          } else {
            return s.substring(delimiterIndex + 1);
          }
        });
  }

  public static String getCmd(GroupMessageEvent groupMessageEvent) {
    return get(
        groupMessageEvent,
        s -> {
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

  @SneakyThrows
  public static SingleMessage buildMessage(Group group, Path path) {
    if (path.endsWith(".txt")) {
      return new PlainText(Files.readString(path));
    } else if (path.endsWith(".mp3")) {
      return group.uploadAudio(ExternalResource.create(path.toFile()));
    } else if (path.endsWith(".jpg")) {
      return group.uploadImage(ExternalResource.create(path.toFile()));
    } else if (path.endsWith(".mp4")) {
      return group.uploadShortVideo(
          ExternalResource.create(path.toFile()),
          ExternalResource.create(path.toFile()),
          "question");
    } else {
      return null;
    }
  }
}
