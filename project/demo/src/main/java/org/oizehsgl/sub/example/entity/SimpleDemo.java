package org.oizehsgl.sub.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 简单示例表 数据模型
 * </p>
 *
 * @author oizehsgl
 * @since 2023-04-09 10:07:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("t_simple_demo")
@ApiModel(value = "SimpleDemo对象", description = "简单示例表")
public class SimpleDemo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty("创建用户")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty("更新用户")
    @TableField("update_user")
    private String updateUser;

    @ApiModelProperty("创建时刻")
    @TableField(value = "create_datetime", fill = FieldFill.INSERT)
    private LocalDateTime createDatetime;

    @ApiModelProperty("更新时刻")
    @TableField(value = "update_datetime", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDatetime;

    @ApiModelProperty("删除状态")
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty("删除时刻")
    @TableField("delete_datetime")
    private Boolean deleteDatetime;

    @ApiModelProperty("版本")
    @TableField("version")
    @Version
    private Long version;
}
