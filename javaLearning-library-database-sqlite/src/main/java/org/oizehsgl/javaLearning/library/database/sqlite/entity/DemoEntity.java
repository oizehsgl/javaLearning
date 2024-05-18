package org.oizehsgl.javaLearning.library.database.sqlite.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 示例po
 *
 * @author oizehsgl
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("demo_table")
public class DemoEntity {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
}
