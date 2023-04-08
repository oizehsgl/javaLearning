package org.oizehsgl.sub;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * generatorTest
 *
 * @author oizehsgl
 * @since 4/8/23
 */
@SpringBootTest
public class GeneratorTest {
    @Test
    public void testGenerator() {
        //这里按着给的注解修改参数即可

        //手动配置数据源
        // jdbc路径
        String url = "jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        // 用户
        String username = "bdtd";
        // 密码
        String password = "Mima!@2202";

        //数据库表的设置
        List<String> listTable = Arrays.asList("user");  //设置需要自动代码生成的表名
        List<String> listTableSuffix = Arrays.asList("_b");    //设置 过滤 表的后缀
        List<String> listTablePrefix = Arrays.asList("t_", "c_"); //设置 过滤 表的前缀

        //基本信息
        String author = "oizehsgl";    //作者
        String parent = "org.oizehsgl.sub";   //父包名
        String module = "example";   //模块包名


        //1、配置数据源
        FastAutoGenerator.create(url, username, password)
                //2、全局配置
                .globalConfig(builder -> {
                    builder
                            //作者
                            .author(author)
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
                })
                //3、包配置
                .packageConfig(builder -> {
                    builder
                            //父包
                            .parent(parent)
                            //模块包名
                            .moduleName(module)
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
                            .pathInfo(Collections.singletonMap(OutputFile.mapper.xml, System.getProperty("user.dir") + "/src/main/resources/mapper"));
                })
                //4、策略配置
                .strategyConfig(builder -> {
                    builder
                            //开启大写
                            .enableCapitalMode()
                            //创建实体类的时候跳过视图
                            .enableSkipView()
                            // 设置需要生成的数据表名
                            .addInclude(listTable)
                            //设置 过滤 表的后缀
                            .addTableSuffix(listTableSuffix)
                            // 设置 过滤 表的前缀
                            .addTablePrefix(listTablePrefix)
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

                })
                //5、模板: Velocity Beetl Freemarker Enjoy
                .templateEngine(new FreemarkerTemplateEngine())
                //6、执行
                .execute();
    }
}
