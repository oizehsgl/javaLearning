package org.oizehsgl.springBoot.properties.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 数据库环境启动处理器
 *
 * @author oizehsgl
 */
@Slf4j
public class DatabaseEnvironmentPostProcessor implements EnvironmentPostProcessor {
  public static final String TEST_PROPERTY = "database.property";
  public static final String RESULT = "result";

  @Override
  public void postProcessEnvironment(
      ConfigurableEnvironment environment, SpringApplication application) {
    // 属性源
    Map<String, Object> propertySource = new HashMap<>();
    Map<String, String> propertySourceSqlMap = new HashMap<>();
    propertySourceSqlMap.put(TEST_PROPERTY, "select 1 as " + RESULT);
    // 创建数据源
    System.out.println(environment.getProperty("spring.datasource.url"));
    DataSource dataSource =
        DataSourceBuilder.create()
            .url(environment.getProperty("spring.datasource.url"))
            .driverClassName(environment.getProperty("spring.datasource.driver-class-name"))
            .username(environment.getProperty("spring.datasource.username"))
            .password(environment.getProperty("spring.datasource.password"))
            .build();
    // 连接数据源并组装查询语句
    try (Connection connection = dataSource.getConnection()) {
      for (Map.Entry<String, String> entry : propertySourceSqlMap.entrySet()) {
        // 查询数据
        try (PreparedStatement preparedStatement = connection.prepareStatement(entry.getValue());
            ResultSet resultSet = preparedStatement.executeQuery()) {
          // 设置属性源
          while (resultSet.next()) {
            Optional.ofNullable(resultSet.getString(RESULT))
                .ifPresent(r -> propertySource.put(entry.getKey(), r));
          }
          // 清空查询语句
          preparedStatement.clearParameters();
        } catch (Exception e) {
          log.error(e.getMessage(), e);
        }
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
    // 添加到最高优先级属性源
    environment
        .getPropertySources()
        .addFirst(new MapPropertySource("config via database", propertySource));
    System.out.println(environment);
  }
}
