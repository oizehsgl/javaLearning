package org.oizehsgl.javaLearning.library.sqlite.Po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

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
public class DemoPo {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
}
