package org.oizehsgl.javaLearning.library.mirai;

import lombok.RequiredArgsConstructor;
import org.oizehsgl.javaLearning.library.mirai.service.ProjectService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JavaLearningLibraryMiraiApplicationRunner implements ApplicationRunner {
    private final ProjectService projectService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        projectService.start();
    }
}
