package org.oizehsgl.javaLearning.library.database.dynamic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author oizehsgl
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("demo")
public class DemoEntity {
    private Long id;
    private String code;
    private String name;
}
