package org.oizehsgl.sub.jpa;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * manualInsertGenerator
 *
 * @author oizehsgl
 * @since 3/19/23
 */
public class ManualInsertGenerator extends IdentityGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) throws HibernateException {
        Serializable id = s.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, s);

        if (id != null && Integer.valueOf(id.toString()) > 0) {
            return id;
        } else {
            return super.generate(s, obj);
        }
    }

}