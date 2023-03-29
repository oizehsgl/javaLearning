package org.oizehsgl.sub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.oizehsgl.sub.entity.LogicDelete;

import java.util.List;

/**
 * logicDeleteService
 *
 * @author oizehsgl
 * @since 3/29/23
 */
public interface LogicDeleteService extends IService<LogicDelete> {
    List<LogicDelete> findDeleted();
    List<LogicDelete> findOdd();
    List<LogicDelete> findEven();
}
