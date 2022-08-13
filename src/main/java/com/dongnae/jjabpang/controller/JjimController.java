package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.controller.UserController.Result;
import com.dongnae.jjabpang.dto.JjimListDto;
import com.dongnae.jjabpang.repository.JjimItemRepository;
import com.dongnae.jjabpang.service.JjimService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.dongnae.jjabpang.controller
 * fileName       : JjimController
 * author         : jihye94
 * date           : 2022-08-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-13        jihye94       최초 생성
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "찜")
@RequestMapping("/api/jjim")
public class JjimController {
      private final JjimService jjimService;
      private final JjimItemRepository jjimItemRepository;
      
      @ApiOperation(value = "사용자별 찜리스트 조회")
      @GetMapping("/jjim")
      public Result findJjimByUser(@RequestBody JjimListDto jjimListDto) {
            jjimItemRepository.findListByUserNo(jjimListDto.getUserNo());
      }
      
}
