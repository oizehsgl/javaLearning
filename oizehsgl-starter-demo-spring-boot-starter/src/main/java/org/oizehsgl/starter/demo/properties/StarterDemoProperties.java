package org.oizehsgl.starter.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author oizehsgl
 */
@Data
@ConfigurationProperties("starter.demo")
public class StarterDemoProperties {
    /**
     * 编码
     */
    private String code="code";
    /**
     * 名称
     */
    private String name="name";
}
