package org.oizehsgl.sub.generator.config;

import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Consumer;

/**
 * DemoInjectionConfig
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@Getter
@Component
public class DemoInjectionConfig {
    private Consumer<InjectionConfig.Builder> builderConsumer = new Consumer<InjectionConfig.Builder>() {
        @Override
        public void accept(InjectionConfig.Builder builder) {
            builder
                    .customMap(Map.of(
                            "a", 1,
                            "b", 2
                    ))
                    .customFile(file -> file
                            .fileName("Manager.java")
                            .packageName("manager")
                            .filePath(System.getProperty("user.dir") + "/src/main/java/org/oizehsgl/sub/example")
                            .templatePath("/templates/manager.java.ftl")
                            .enableFileOverride()
                    );
        }
    };
}