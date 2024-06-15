package org.oizehsgl.springBoot.restart.service;

import jakarta.annotation.Resource;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.stereotype.Service;

/**
 * 重启服务层
 *
 * @author oizehsgl
 */
@Service
public class RestartService {
  @Resource private RestartEndpoint restartEndpoint;

  public void restartApp() {
    restartEndpoint.restart();
  }
}
