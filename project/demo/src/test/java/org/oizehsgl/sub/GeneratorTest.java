package org.oizehsgl.sub;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.generator.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * generatorTest
 *
 * @author oizehsgl
 * @since 4/8/23
 */
@SpringBootTest
public class GeneratorTest {
    @Autowired
    private DemoDataSourceConfig demoDataSourceConfig;
    @Autowired
    private DemoGlobalConfig demoGlobalConfig;
    @Autowired
    private DemoInjectionConfig demoInjectionConfig;
    @Autowired
    private DemoPackageConfig demoPackageConfig;
    @Autowired
    private DemoStrategyConfig demoStrategyConfig;
    @Autowired
    private DemoTemplateConfig demoTemplateConfig;

    @Test
    public void testGenerator() {
        //创建数据源
        FastAutoGenerator.create(demoDataSourceConfig.getBuilder())
                //数据配置
                .dataSourceConfig(demoDataSourceConfig.getBuilderConsumer())
                //全局配置
                .globalConfig(demoGlobalConfig.getBuilderConsumer())
                //包配置
                .packageConfig(demoPackageConfig.getBuilderConsumer())
                //策略配置
                .strategyConfig(demoStrategyConfig.getBuilderConsumer())
                //注入配置
                .injectionConfig(demoInjectionConfig.getBuilderConsumer())
                //模板配置
                .templateConfig(demoTemplateConfig.getBuilderConsumer())
                //模板引擎
                .templateEngine(demoTemplateConfig.getTemplateEngine())
                //执行
                .execute();
    }
}
