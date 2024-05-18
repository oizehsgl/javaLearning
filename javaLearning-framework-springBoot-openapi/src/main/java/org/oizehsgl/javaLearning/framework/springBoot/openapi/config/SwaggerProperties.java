package org.oizehsgl.javaLearning.framework.springBoot.openapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * swagger配置
 *
 * @author oizehsgl
 */
@Data
@Component
@ConfigurationProperties("swagger")
public class SwaggerProperties {

    /**
     * 项目应用名
     */
    private String applicationName;

    /**
     * 项目版本信息
     */
    private String applicationVersion;

    /**
     * 项目描述信息
     */
    private String applicationDescription;

    /**
     * 接口调试地址
     */
    private String tryHost;

}