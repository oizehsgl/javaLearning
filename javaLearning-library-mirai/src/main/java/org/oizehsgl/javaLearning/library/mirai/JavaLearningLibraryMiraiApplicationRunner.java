package org.oizehsgl.javaLearning.library.mirai;

import jakarta.annotation.Resource;
import org.oizehsgl.javaLearning.library.mirai.service.ProjectService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class JavaLearningLibraryMiraiApplicationRunner implements ApplicationRunner {
  @Resource private ProjectService projectService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    projectService.start();
  }
}
