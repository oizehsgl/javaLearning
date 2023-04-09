package org.oizehsgl.sub.config;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * DemoStrategyConfig
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@Getter
@Component
public class DemoStrategyConfig {
    private Consumer<StrategyConfig.Builder> builderConsumer = new Consumer<StrategyConfig.Builder>() {
        @Override
        public void accept(StrategyConfig.Builder builder) {
            builder
                    //开启大写
                    .enableCapitalMode()
                    //创建实体类的时候跳过视图
                    .enableSkipView()
                    // 设置需要生成的数据表名
                    .addInclude(Arrays.asList("user"))
                    //设置 过滤 表的后缀
                    .addTableSuffix(Arrays.asList("_b"))
                    // 设置 过滤 表的前缀
                    .addTablePrefix(Arrays.asList("t_", "c_"))
                    //字段后缀
                    .addFieldSuffix()
                    //字段前缀
                    .addFieldPrefix()

                    //4.1、实体类策略配置
                    .entityBuilder()
                    //覆盖文件
                    .enableFileOverride()
                    //开启链式模型
                    .enableChainModel()
                    // 默认是开启实体类序列化，可以手动disable使它不序列化。由于项目中需要使用序列化就按照默认开启了
                    //.disableSerialVersionUID()
                    // 开启生成实体时生成字段注解
                    .enableTableFieldAnnotation()
                    //开启 Lombok
                    .enableLombok()
                    //乐观锁字段名(数据库)
                    .versionColumnName("version")
                    //乐观锁属性名(实体)
                    .versionPropertyName("version")
                    //逻辑删除字段名(数据库)
                    .logicDeleteColumnName("deleted")
                    //逻辑删除属性名(实体)
                    .logicDeletePropertyName("deleteFlag")
                    //数据库表映射到实体的命名策略：默认是下划线转驼峰命。这里可以不设置
                    .naming(NamingStrategy.underline_to_camel)
                    //数据库表字段映射到实体的命名策略：下划线转驼峰命。（默认是和naming一致，所以也可以不设置）
                    .columnNaming(NamingStrategy.underline_to_camel)
                    //添加表字段填充
                    .addTableFills(
                            // "create_time"字段自动填充为插入时间
                            new Column("create_time", FieldFill.INSERT),
                            // "modify_time"字段自动填充为插入修改时间
                            new Column("modify_time", FieldFill.INSERT_UPDATE)
                    )
                    //设置主键自增
                    .idType(IdType.AUTO)

                    //4.2、Controller策略配置
                    .controllerBuilder()
                    //覆盖文件
                    .enableFileOverride()
                    //开启驼峰连转字符
                    .enableHyphenStyle()
                    //格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
                    .formatFileName("%sController")
                    //开启生成 @RestController 控制器
                    .enableRestStyle()

                    //4.3、service 策略配置
                    .serviceBuilder()
                    //覆盖文件
                    .enableFileOverride()
                    //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                    .formatServiceFileName("%sService")
                    //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                    .formatServiceImplFileName("%sServiceImpl")

                    //4.4、Mapper策略配置
                    .mapperBuilder()
                    //覆盖文件
                    .enableFileOverride()
                    //设置父类
                    .superClass(BaseMapper.class)
                    //启用 BaseResultMap 生成
                    .enableBaseResultMap()
                    //启用 BaseColumnList
                    .enableBaseColumnList()
                    //格式化 mapper 文件名称
                    .formatMapperFileName("%sMapper")
                    //开启 @Mapper 注解
                    .enableMapperAnnotation()
                    //格式化Xml文件名称
                    .formatXmlFileName("%sMapper")
                    //格式化Mapper文件名称
                    .formatMapperFileName("%sMapper");
        }
    };
}