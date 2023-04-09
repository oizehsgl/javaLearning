package org.oizehsgl.sub.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import org.oizehsgl.sub.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Accessors;

/**
 * <p>
 * 简单示例表 数据模型
 * </p>
 *
 * @author oizehsgl
 * @since 2023-04-10 12:56:56
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("t_simple_demo")
@ApiModel(value = "SimpleDemo对象", description = "简单示例表")
public class SimpleDemo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;
}
