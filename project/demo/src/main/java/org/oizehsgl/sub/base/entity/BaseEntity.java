package org.oizehsgl.sub.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * baseEntity
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "BaseEntity ", description = "基础实体对象")
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("创建用户")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty("创建时刻")
    @TableField(value = "create_datetime", fill = FieldFill.INSERT)
    private LocalDateTime createDatetime;

    @ApiModelProperty("更新用户")
    @TableField("update_user")
    private String updateUser;

    @ApiModelProperty("更新时刻")
    @TableField(value = "update_datetime", fill = FieldFill.UPDATE)
    private LocalDateTime updateDatetime;

    @ApiModelProperty("删除用户")
    @TableField("delete_user")
    private String deleteUser;

    @ApiModelProperty("删除时刻")
    @TableField("delete_datetime")
    //@TableLogic(delval = "now()", value = "null")
    private LocalDateTime deleteDatetime;

    @ApiModelProperty("删除状态")
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty("版本")
    @TableField("version")
    @Version
    private Long version;
}
