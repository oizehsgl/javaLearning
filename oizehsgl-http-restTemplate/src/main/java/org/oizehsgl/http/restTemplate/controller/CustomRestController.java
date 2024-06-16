package org.oizehsgl.http.restTemplate.controller;

import org.oizehsgl.http.restTemplate.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author oizehsgl
 */
@RestController
@RequestMapping("/rest")
public class CustomRestController {
  @GetMapping("/getUserInfo")
  public User getUserList(Integer id, String name) {
    return User.builder().id(id).name(name).build();
  }

  @PostMapping("/postUserInfo")
  public User postUserInfo(@RequestBody User user) {
    Integer id = user.getId();
    String name = user.getName();
    return User.builder().id(id).name(name).build();
  }
}
