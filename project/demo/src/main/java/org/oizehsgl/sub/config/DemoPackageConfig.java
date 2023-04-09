package org.oizehsgl.sub.config;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * DemoPackageConfig
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@Getter
@Component
public class DemoPackageConfig {
    private Consumer<PackageConfig.Builder> builderConsumer = new Consumer<PackageConfig.Builder>() {
        @Override
        public void accept(PackageConfig.Builder builder) {
            builder
                    //父包
                    .parent("org.oizehsgl.sub")
                    //模块包名
                    .moduleName("example")
                    //实体类包名
                    .entity("entity")
                    //服务包名
                    .service("service")
                    //服务实现包名
                    .serviceImpl("service.impl")
                    //mapper包名
                    .mapper("mapper")
                    //xml名???不起作用？
                    .xml("mapper.xml")
                    //controller名
                    .controller("controller")
                    // 自定义包名(一般不在这里生成，而是后面编写的时候自己建包）
                    //.other("config")
                    //配置 mapper.xml 路径信息：项目的 resources 目录下
                    //.pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper"))
            ;
        }
    };
}