package org.oizehsgl.sub.jpa;

import java.util.List;

/**
 * tableService
 *
 * @author oizehsgl
 * @since 3/19/23
 */
public interface TableService {
    List<TableEntity> findAll();
}
