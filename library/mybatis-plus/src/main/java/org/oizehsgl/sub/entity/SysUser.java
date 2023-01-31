package org.oizehsgl.sub.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class SysUser {
    private Long id;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String name;
    private Integer age;
    private String email;
}
