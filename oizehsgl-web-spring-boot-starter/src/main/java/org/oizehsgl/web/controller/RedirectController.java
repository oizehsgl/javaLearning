package org.oizehsgl.web.controller;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 重定向 控制层
 *
 * @author oizehsgl
 */
@Controller
public class RedirectController {
  @GetMapping(value = "/redirect")
  public ResponseEntity<String> redirect(@RequestParam @Nullable String param) {
    return ResponseEntity.ok("redirectTarget:" + param);
  }

  @GetMapping(value = "/redirect/servlet")
  public void redirectByServlet(HttpServletResponse response) throws IOException {
    response.sendRedirect("/redirect");
  }

  @GetMapping(value = "/redirect/keyword")
  public String redirectByKeyword() {
    return "redirect:/redirect";
  }

  @GetMapping("/redirect/entity")
  public ResponseEntity<Object> redirect() {
    URI location = URI.create("/redirect");
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setLocation(location);
    return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).build();
  }

  @GetMapping("/redirect/modelAndView")
  public ModelAndView redirectByModelAndView() {
    ModelAndView modelAndView = new ModelAndView();
    RedirectView redirectView = new RedirectView("/redirect");
    modelAndView.setView(redirectView);
    modelAndView.addObject("param", "modelAndView");
    return modelAndView;
  }
}
