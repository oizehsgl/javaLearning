package org.oizehsgl.sub;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * subProperty
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Data
@Configuration
@ConfigurationProperties("parameter.sub")
public class SubProperty {
    private Integer integer;

    public static String STATIC_STRING;

    @Value("${parameter.sub.static-string}")
    public void setStaticString(String staticString) {
        STATIC_STRING = staticString;
    }
}
