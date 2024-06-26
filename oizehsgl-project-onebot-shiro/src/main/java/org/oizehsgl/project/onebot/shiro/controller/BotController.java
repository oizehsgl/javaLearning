package org.oizehsgl.project.onebot.shiro.controller;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotContainer;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.oizehsgl.project.onebot.shiro.property.ProjectProperties;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oizehsgl
 */
@RestController
@RequestMapping("/bot")
public class BotController {

  @Resource private ProjectProperties projectProperties;
  @Resource private BotContainer botContainer;

  @GetMapping("/send")
  public String send(@RequestParam @Nullable String message) {
    // 机器人账号
    long botId = projectProperties.getRobotId();
    long groupId = projectProperties.getGroupId();
    // 通过机器人账号取出 Bot 对象
    Bot bot = botContainer.robots.get(botId);
    // 调用 Bot 对象方法
    if (ObjectUtils.isNotEmpty(message) && !"undefined".equals(message)) {
      bot.sendGroupMsg(groupId, message, false);
    }
    return message;
  }
}
