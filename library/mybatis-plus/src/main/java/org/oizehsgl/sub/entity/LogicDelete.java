package org.oizehsgl.sub.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * logicDelete
 *
 * @author oizehsgl
 * @since 3/29/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogicDelete {
    @TableId
    @TableField("id")
    private Integer id;
    @TableField("data")
    private String data;
    //@TableLogic
    @TableField("deleted_integer")
    private Integer deletedInteger;
    //@TableLogic
    @TableField("deleted_boolean")
    private Boolean deletedBoolean;

    @TableLogic(delval = "now()", value = "null")
    @TableField("deleted_datetime")
    private LocalDateTime deletedDatetime;
}
