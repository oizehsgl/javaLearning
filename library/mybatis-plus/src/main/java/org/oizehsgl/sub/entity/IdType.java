package org.oizehsgl.sub.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * idType
 *
 * @author oizehsgl
 * @since 3/7/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdType {
    //@TableId(type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
    //@TableId(type = com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID)
    //@TableId(type = com.baomidou.mybatisplus.annotation.IdType.NONE)
    //@TableId(type = com.baomidou.mybatisplus.annotation.IdType.INPUT)
    //@TableId
    private Integer intId;
    //@TableId(type = com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID)
    //@TableId(type = com.baomidou.mybatisplus.annotation.IdType.NONE)
    //@TableId(type = com.baomidou.mybatisplus.annotation.IdType.INPUT)
    @TableId(type = com.baomidou.mybatisplus.annotation.IdType.ASSIGN_UUID)
    //@TableId
    private String stringId;
    private String data;
}
