package org.oizehsgl.javaLearning.guava.demo.concurrent;

import com.google.common.util.concurrent.MoreExecutors;

/**
 * @author oizehsgl
 */
public class CustomSequentialExecutor {
    MoreExecutors moreExecutors;
    public void test(){
        MoreExecutors.newSequentialExecutor(null);
    }
}
