package org.oizehsgl.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Data
@Component
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
