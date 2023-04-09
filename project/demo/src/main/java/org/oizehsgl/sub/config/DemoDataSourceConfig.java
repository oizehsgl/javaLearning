package org.oizehsgl.sub.config;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * demoDataSourceConfig
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@Getter
@Component
public class DemoDataSourceConfig {
    private DataSourceConfig.Builder builder = new DataSourceConfig.Builder(
            "jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8",
            "bdtd",
            "Mima!@2202"
    );
    private Consumer<DataSourceConfig.Builder> builderConsumer = new Consumer<DataSourceConfig.Builder>() {
        @Override
        public void accept(DataSourceConfig.Builder builder) {
        }
    };
}
