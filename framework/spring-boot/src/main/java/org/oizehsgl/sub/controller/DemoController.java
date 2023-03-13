package org.oizehsgl.sub.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 *
 * @author oizehsgl
 * @Controller 控制器
 * @ResponseBody 返回json, xml
 * @RestController 返回json, 不能返回html
 * @since 3/13/23
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping(value = "/get/{s}", params = {"user=user", "pswd=pswd"}, headers = "HOST=localhost:8080", method = RequestMethod.GET)
    public String get(@PathVariable(name = "s") String ss) {
        return ss;
    }

    @PostMapping("/post")
    public String post(@RequestParam(name = "s") String ss, @Validated @RequestBody DemoData demoData) {
        return ss + "--" + demoData;
    }

    @PutMapping("/put")
    public String put(String s, @Validated(Group.Insert.class) @RequestBody DemoData demoData) {
        return s + "--" + demoData;
    }

    @DeleteMapping("/delete/{s:^[1][3,4,5,7,8][0-9]{9}$}")
    public String delete(@PathVariable(name = "s") String phone) {
        return phone;
    }
}
