package org.oizehsgl.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 转发控制层
 *
 * @author oizehsgl
 */
@Controller
public class ForwardController {
  @GetMapping(value = "/forward")
  public ResponseEntity<String> forward(@RequestParam @Nullable String param) {
    return ResponseEntity.ok("forwardTarget:" + param);
  }

  @GetMapping(value = "/forward/servlet")
  public void forwardByServlet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/forward").forward(request, response);
  }

  @GetMapping(value = "/forward/keyword")
  public String forwardByKeyword() {
    return "forward:/forward";
  }

  @GetMapping("/forward/modelAndView")
  public ModelAndView forwardByModelAndView() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("forward:/forward");
    return modelAndView;
  }
}
