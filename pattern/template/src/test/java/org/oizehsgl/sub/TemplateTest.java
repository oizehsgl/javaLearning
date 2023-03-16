package org.oizehsgl.sub;

import org.junit.Test;

/**
 * templateTest
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class TemplateTest {
    @Test
    public void testTemplate() {
        DemoTemplate demoTemplate;
        demoTemplate = new AlphaDemoTemplate();
        demoTemplate.start();
        demoTemplate = new BetaDemoTemplate();
        demoTemplate.start();
        demoTemplate = new GammaDemoTemplate();
        demoTemplate.start();
    }
}
