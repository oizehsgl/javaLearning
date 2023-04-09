package org.oizehsgl.sub.generator.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * DemoMetaObjectHandler
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@Component
public class DemoMetaObjectHandler implements MetaObjectHandler {
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
