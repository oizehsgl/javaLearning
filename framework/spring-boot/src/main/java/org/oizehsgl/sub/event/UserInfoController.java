package org.oizehsgl.sub.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * userInfoController
 *
 * @author oizehsgl
 * @since 3/18/23
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/{id}")
    public UserInfo getUserInfo(@PathVariable Long id) {
        return userInfoService.findOne(id);
    }

    @PostMapping
    public UserInfo createUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.create(userInfo);
    }
}
