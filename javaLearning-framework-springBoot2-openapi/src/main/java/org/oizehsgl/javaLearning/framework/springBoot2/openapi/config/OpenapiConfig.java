package org.oizehsgl.javaLearning.framework.springBoot2.openapi.config;

import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.servers.Server;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

/**
 * openapi配置类
 *
 * @author oizehsgl
 */
@Configuration
public class OpenapiConfig {
  @Bean
  public OpenAPI openAPI() {
    Info info =
        new Info()
            .title("SDAE接口文档")
            .version("1.0")
            .description("记录SDAE对外暴露的接口")
            .termsOfService("https://company.com/term")
            .license(new License().name("xxLicense").url("https://license.com"))
            .contact(
                new Contact()
                    .name("company")
                    .email("company@gmail.com")
                    .url("https://company.com"));
    List<Server> serverList =
        new ArrayList<>() {
          {
            add(new Server().description("development").url("http://localhost:8080"));
            add(new Server().description("production").url("http://127.0.0.1:8080"));
          }
        };

    // mapSchema
    MapSchema mapSchema = new MapSchema();
    ResolvedSchema resolvedSchema =
        ModelConverters.getInstance()
            .resolveAsResolvedSchema(new AnnotatedType(ResponseEntity.class));
    // add
    ResolvedSchema raoGroupDtoSchema =
        ModelConverters.getInstance()
            .resolveAsResolvedSchema(new AnnotatedType(ResponseEntity.class));
    resolvedSchema.schema.addProperty(
        "raoGroup", new ArraySchema().items(raoGroupDtoSchema.schema));
    mapSchema.addProperty("result", new NumberSchema());
    mapSchema.addProperty("resultMessage", new StringSchema());
    mapSchema.addProperty("data", resolvedSchema.schema);
    return new OpenAPI().info(info).servers(serverList);
  }
}
