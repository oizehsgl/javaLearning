package com.example.springBoot;

import com.example.springBoot.customAnnotation.CustomAnnotSubService;
import com.example.springBoot.customAnnotation.CustomAnnotSupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 * @since 6/1/23
 */
@SpringBootTest
public class CustomAnnotTest {
    @Autowired
    private CustomAnnotSupService customAnnotSupService;
    @Autowired
    private CustomAnnotSubService customAnnotSubService;
    @Test
    public void testMethodPointCut(){
        customAnnotSupService.method();
        customAnnotSubService.method();
    }
}
