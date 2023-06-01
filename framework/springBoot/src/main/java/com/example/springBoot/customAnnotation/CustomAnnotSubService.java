package com.example.springBoot.customAnnotation;

import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 * @since 6/1/23
 */
@Service
public class CustomAnnotSubService extends CustomAnnotSupService{
    @Override
    public void method() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
        System.out.printf("%s->%s%n",stackTraceElement.getClassName(),stackTraceElement.getMethodName());
    }
}
