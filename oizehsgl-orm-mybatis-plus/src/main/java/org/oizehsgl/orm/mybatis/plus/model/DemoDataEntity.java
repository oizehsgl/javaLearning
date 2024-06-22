package org.oizehsgl.orm.mybatis.plus.model;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author oizehsgl
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("demo_data")
public class DemoDataEntity extends BaseEntity {
  private String name;
  @TableField(updateStrategy = FieldStrategy.ALWAYS)
  private Integer age;
  private String email;
}
