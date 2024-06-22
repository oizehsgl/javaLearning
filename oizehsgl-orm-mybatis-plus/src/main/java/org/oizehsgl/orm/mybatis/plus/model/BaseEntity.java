package org.oizehsgl.orm.mybatis.plus.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author oizehsgl
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

  @TableId private Long id;
  //// @TableId(type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
  //// @TableId(type = com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID)
  //// @TableId(type = com.baomidou.mybatisplus.annotation.IdType.NONE)
  //// @TableId(type = com.baomidou.mybatisplus.annotation.IdType.INPUT)
  //// @TableId
  // private Integer intId;
  //// @TableId(type = com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID)
  //// @TableId(type = com.baomidou.mybatisplus.annotation.IdType.NONE)
  //// @TableId(type = com.baomidou.mybatisplus.annotation.IdType.INPUT)
  // @TableId(type = com.baomidou.mybatisplus.annotation.IdType.ASSIGN_UUID)
  //// @TableId
  // private String stringId;

  @TableLogic private Boolean deleted;
  //// @TableLogic
  // @TableField("deleted_integer")
  // private Integer deletedInteger;
  //// @TableLogic
  // @TableField("deleted_boolean")
  // private Boolean deletedBoolean;
  // @TableLogic(delval = "now()", value = "null")
  // @TableField("deleted_datetime")
  // private LocalDateTime deletedDatetime;
}
