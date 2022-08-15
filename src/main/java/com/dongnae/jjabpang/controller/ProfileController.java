package com.dongnae.jjabpang.controller;

/*
  packageName    : com.dongnae.jjabpang.controller
  fileName       : ProfileController
  author         : jihye94
  date           : 2022-08-14
  description    :
  ===========================================================
  DATE              AUTHOR             NOTE
  -----------------------------------------------------------
  2022-08-14        jihye94       최초 생성
 */

import io.swagger.annotations.Api;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@Api(tags = "프로파일 확인")
public class ProfileController {
      private final Environment env;
      
      public ProfileController(Environment env) {
            this.env = env;
      }
      
      @GetMapping("/profile")
      public String profile() {
            return Arrays.stream(env.getActiveProfiles())
                         .findFirst()
                         .orElse("");
      }
}