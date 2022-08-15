package com.dongnae.jjabpang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.dongnae.jjabpang.controller
 * fileName       : LoggingController
 * author         : qkrtkdwns3410
 * date           : 2022-08-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-15        qkrtkdwns3410       최초 생성
 */
@RestController
public class LoggingController {
      
      @Value("${logging-module.version}")
      private String version;
      
      @GetMapping("/version")
      public String version() {
            return String.format("Project Version : %s", version);
      }
      
      @GetMapping("/health")
      public String checkHealth() {
            return "healthy";
      }
      
}