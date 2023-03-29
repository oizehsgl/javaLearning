package org.oizehsgl.sub.transcation;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.oizehsgl.sub.jpa.TableEntity;
import org.oizehsgl.sub.jpa.TableRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * transactionalDemo
 *
 * @author oizehsgl
 * @since 3/22/23
 */
@Component
@RequiredArgsConstructor
public class TransactionalDemo {
    private final TableRepository tableRepository;

    @Lazy
    private TransactionalDemo transactionalDemo;

    @PostConstruct
    public void init() {
        List<TableEntity> tableEntityList = new ArrayList<>();
        TableEntity tableEntity = TableEntity.builder().build();
        tableEntity.setInteger(1);
        tableEntity.setString("1");
        tableRepository.save(tableEntity);
        TableEntity tableEntity2 = TableEntity.builder().build();
        tableEntity2.setInteger(2);
        tableEntity2.setString("2");
        tableRepository.save(tableEntity2);
    }

    public TableEntity get() {
        return tableRepository.findById(1L).get();
    }
    public void reset() {
        TableEntity tableEntity = tableRepository.findById(1L).get();
        tableEntity.setInteger(1);
        tableRepository.save(tableEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void testTransactional1() {
        TableEntity tableEntity = tableRepository.findById(1L).get();
        tableEntity.setInteger(null);
        tableRepository.save(tableEntity);
        throw new RuntimeException();
    }
    public void testTransactional2() {
        TableEntity tableEntity = tableRepository.findById(1L).get();
        tableEntity.setInteger(null);
        tableRepository.save(tableEntity);
        throw new RuntimeException();
    }
    public void testTransactional3() {
        testTransactional1();
    }
    public void testTransactional4() {
        transactionalDemo.testTransactional1();
    }


    //@Scheduled(fixedDelay = 1000)
    //@Transactional(rollbackFor = Exception.class)
    //@Lock(value = LockModeType.PESSIMISTIC_WRITE)
    public void testValue1() {
        try {
            TableEntity tableEntity = tableRepository.findById(1L).get();
            System.out.printf("%s: %s%n", Thread.currentThread().getStackTrace()[1].getMethodName(), tableEntity);
            tableEntity.setInteger(tableEntity.getInteger() + 1);
            tableRepository.save(tableEntity);
        } catch (Exception e) {
            System.out.printf("%s: %s%n", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            throw new RuntimeException();
        }
    }

    //@Scheduled(fixedDelay = 1000)
    //@Transactional(rollbackFor = Exception.class)
    //@Lock(value = LockModeType.PESSIMISTIC_WRITE)
    public void testValue2() {
        try {
            TableEntity tableEntity = tableRepository.findById(1L).get();
            System.out.printf("%s: %s%n", Thread.currentThread().getStackTrace()[1].getMethodName(), tableEntity);
            //tableEntity.setString(tableEntity.getString() + 1);
            tableEntity.setInteger(tableEntity.getInteger() - 1);
            tableRepository.save(tableEntity);
            //TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            System.out.printf("%s: %s%n", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            throw new RuntimeException();
        }
    }


}
