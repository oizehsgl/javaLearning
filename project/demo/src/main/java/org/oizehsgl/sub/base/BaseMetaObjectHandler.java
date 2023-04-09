package org.oizehsgl.sub.base;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * BaseMetaObjectHandler
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@Component
public class BaseMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("deleted", false, metaObject);
        this.setFieldValByName("version", 1L, metaObject);

        this.strictInsertFill(metaObject, "createDatetime", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateDatetime", LocalDateTime.class, LocalDateTime.now());
    }
}
