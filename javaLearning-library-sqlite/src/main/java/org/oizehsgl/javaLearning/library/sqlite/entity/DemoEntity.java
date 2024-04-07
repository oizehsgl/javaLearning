package org.oizehsgl.javaLearning.library.sqlite.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 示例po
 *
 * @author yueyuanzhi
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
