package org.oizehsgl.sub.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * tableServiceImpl
 *
 * @author oizehsgl
 * @since 3/19/23
 */
@Slf4j
@Service("userService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {
    private final TableRepository tableRepository;

    @Override
    public List<TableEntity> findAll() {
        List<TableEntity> tableEntityList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TableEntity tableEntity = TableEntity.builder()
                    .id(i + 10L)
                    .string(String.valueOf(i))
                    .integer(i)
                    .build();
            tableEntityList.add(tableEntity);
        }
        tableRepository.saveAll(tableEntityList);
        List<TableEntity> tableEntities = tableRepository.findAll();
        return tableRepository.findAll();
    }
}
