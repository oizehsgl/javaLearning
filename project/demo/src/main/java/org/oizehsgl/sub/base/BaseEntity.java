package org.oizehsgl.sub.base;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * baseEntity
 *
 * @author oizehsgl
 * @since 4/9/23
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("创建用户")
    private String createUser;

    @ApiModelProperty("更新用户")
    private String modifyUser;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime modifyTime;

    @ApiModelProperty("删除状态")
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty("版本")
    @Version
    private Long version;
}
