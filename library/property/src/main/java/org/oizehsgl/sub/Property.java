package org.oizehsgl.sub;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * property
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Data
@Configuration
@ConfigurationProperties("parameter")
public class Property {
    private String stringHead;
    private String stringTail;
    private Integer intRandom;
    private int[] intArray;
    private String[] strArray;
    private List<String> stringList;
    private List<Map<String, String>> mapList;
    private Map<String, String> map;
    @Autowired
    private SubProperty sub;
}
