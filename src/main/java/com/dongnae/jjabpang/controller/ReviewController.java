package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.dto.ReviewDto;
import com.dongnae.jjabpang.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *packageName    : com.dongnae.jjabpang.controller
 * fileName       : ItemController
 * author         : ipeac
 * date           : 2022-08-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-04        ipeac       최초 생성
 */
@RequestMapping("/api/review/")
@RestController
@Slf4j
@RequiredArgsConstructor
@Api(tags = "리뷰")
public class ReviewController {
      private final ReviewService reviewService;
      
      @PostMapping(name = "/review")
      @ApiOperation(value = "리뷰작성")
      public ResponseEntity addReview(@RequestBody ReviewDto reviewDto) {
            reviewService.addReview(reviewDto);
      }
}
