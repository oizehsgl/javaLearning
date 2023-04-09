package org.oizehsgl.sub.generator.config;

import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * DemoTemplateConfig
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@Getter
@Component
public class DemoTemplateConfig {
    private AbstractTemplateEngine templateEngine = new FreemarkerTemplateEngine();
    private Consumer<TemplateConfig.Builder> builderConsumer = new Consumer<TemplateConfig.Builder>() {
        @Override
        public void accept(TemplateConfig.Builder builder) {
        }
    };
}