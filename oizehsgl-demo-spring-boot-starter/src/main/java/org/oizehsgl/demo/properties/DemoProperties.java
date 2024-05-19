package org.oizehsgl.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author oizehsgl
 */
@Data
@ConfigurationProperties("demo")
public class DemoProperties {
    /**
     * 编码
     */
    private String code="code";
    /**
     * 名称
     */
    private String name="name";
}
