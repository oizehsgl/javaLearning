package org.oizehsgl.javaLearning.library.mirai.controller;

import jakarta.annotation.Resource;
import java.util.Objects;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Group;
import org.apache.commons.lang3.ObjectUtils;
import org.oizehsgl.javaLearning.library.mirai.property.ProjectProperties;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 机器人控制层
 *
 * @author oizehsgl
 */
@RestController
@RequestMapping("/bot")
public class BotController {
  @Resource private Bot bot;
  @Resource private ProjectProperties projectProperties;

  private Group group;

  @GetMapping("/send")
  public String send(@RequestParam @Nullable String message) {
    if (Objects.isNull(group)) {
      group = bot.getGroup(projectProperties.getGroupId());
    }
    if (ObjectUtils.isNotEmpty(message) && !"undefined".equals(message)) {
      group.sendMessage(message);
      return message;
    }
    return null;
  }
}
