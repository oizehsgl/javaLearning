package org.oizehsgl.sub;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * cacheDemoServiceImpl
 *
 * @author oizehsgl
 * @since 4/7/23
 */
@Service
public class CacheDemoServiceImpl extends ServiceImpl<CacheDemoMapper, CacheDemo> implements ICacheDemoService {
    @Override
    public List<CacheDemo> listCache() {
        System.out.println("listCache");
        return this.list();
    }

    @Scheduled(fixedDelay = 1000)
    public void testCache2() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("2-1");
        this.listCache().stream().forEach(System.out::println);
        stopWatch.stop();
        stopWatch.start("2-2");
        this.listCache().stream().forEach(System.out::println);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
