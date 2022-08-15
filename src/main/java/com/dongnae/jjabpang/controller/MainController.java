package com.dongnae.jjabpang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *packageName    : com.dongnae.jjabpang.controller
 * fileName       : MainController
 * author         : ipeac
 * date           : 2022-08-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-15        ipeac       최초 생성
 */
@Controller
public class MainController {
      
      @GetMapping("/index")
      public String index() {
            return "hello";
      }
}
