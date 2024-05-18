package org.oizehsgl.javaLearning.framework.springBoot2.openapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.oizehsgl.javaLearning.framework.springBoot2.openapi.vo.DemoVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例控制器
 *
 * @author oizehsgl
 */
@Tag(name = "demo tag", description = "用于简单测试的API")
@RestController
public class DemoController {
    @Operation( summary = "demo", description = "一个简单的测试接口")
    @Parameter(name = "name", description = "名称", required = true, example = "world")
    @GetMapping("/list")
    public String demo(DemoVo demoVo) {
        return demoVo.toString();
    }
}
