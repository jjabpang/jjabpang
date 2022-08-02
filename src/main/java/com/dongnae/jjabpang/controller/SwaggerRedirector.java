package com.dongnae.jjabpang.controller;
/*
 *packageName    : com.dongnae.jjabpang.controller
 * fileName       : SwaggerRedirector
 * author         : ipeac
 * date           : 2022-08-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-02        ipeac       최초 생성
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/usage")
class SwaggerRedirector {
      @GetMapping
      public String api() {
            return "redirect:/swagger-ui/index.html";
      }
}
