package org.oizehsgl.sub.config;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * demoGlobalConfig
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@Getter
@Component
public class DemoGlobalConfig {
    private Consumer<GlobalConfig.Builder> builderConsumer = new Consumer<GlobalConfig.Builder>() {
        @Override
        public void accept(GlobalConfig.Builder builder) {
            builder
                    //作者
                    .author("123456")
                    //设置输出路径：项目的 java 目录下【System.getProperty("user.dir")意思是获取到项目所在的绝对路径】
                    .outputDir(System.getProperty("user.dir") + "/src/main/java")
                    //注释日期
                    .commentDate("yyyy-MM-dd hh:mm:ss")
                    //定义生成的实体类中日期的类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date;
                    .dateType(DateType.ONLY_DATE)
                    //开启swagger
                    .enableSwagger()
                    //不打开目录
                    .disableOpenDir();
        }
    };
}
