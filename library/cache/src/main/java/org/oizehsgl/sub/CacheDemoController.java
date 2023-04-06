package org.oizehsgl.sub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * cacheDemoController
 *
 * @author oizehsgl
 * @since 4/7/23
 */
@RestController("/cache")
public class CacheDemoController {
    @GetMapping
    public ResponseBody get() {
        return null;
    }
}
