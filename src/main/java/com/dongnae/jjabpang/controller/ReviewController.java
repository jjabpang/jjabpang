package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.controller.UserController.Result;
import com.dongnae.jjabpang.dto.ReviewDto;
import com.dongnae.jjabpang.dto.ReviewListDto;
import com.dongnae.jjabpang.dto.condition.ReviewSearchCondition;
import com.dongnae.jjabpang.response.Message;
import com.dongnae.jjabpang.response.StatusEnum;
import com.dongnae.jjabpang.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

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
@RequestMapping("/api/review")
@RestController
@Slf4j
@RequiredArgsConstructor
@Api(tags = "리뷰")
public class ReviewController {
      private final ReviewService reviewService;
      
      @PostMapping("/review")
      @ApiOperation(value = "리뷰작성")
      public ResponseEntity addReview(@RequestBody ReviewDto reviewDto) {
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            
            // 리뷰 (이미지 제외) 작성
            Long reviewNo = reviewService.addReview(reviewDto);
            // 이미지 업로드
            Integer affectedRows = reviewService.addImage(reviewDto, reviewNo);
            
            message.setStatus(StatusEnum.OK);
            message.setMessage("리뷰 작성 성공, data : 리뷰번호");
            message.setData(reviewNo);
            
            return new ResponseEntity(message, headers, HttpStatus.OK);
      }
      
      @GetMapping("/review")
      @ApiOperation(value = "리뷰 조회 - 페이징; ")
      public Result findReview(@RequestBody ReviewSearchCondition searchCondition, Pageable pageable) {
            
            log.debug("searchCondition = " + searchCondition);
            
            List<ReviewListDto> content = reviewService.findReviewList(searchCondition, pageable);
            
            
            return new Result(content);
      }
      
      
      @DeleteMapping("/review/{reviewNo}")
      @ApiOperation(value = "리뷰 삭제")
      public ResponseEntity removeReview(@PathVariable Long reviewNo) {
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            try {
                  reviewService.removeReview(reviewNo);
                  
            } catch (Exception e) {
                  message.setData(reviewNo);
                  message.setStatus(StatusEnum.BAD_REQUEST);
                  message.setMessage("리뷰 삭제 실패 , data : 리뷰번호");
                  return new ResponseEntity(message, headers, HttpStatus.BAD_REQUEST);
                  
            }
            message.setData(reviewNo);
            message.setStatus(StatusEnum.OK);
            message.setMessage("리뷰 삭제 성공 , data : 리뷰번호");
            return new ResponseEntity(message, headers, HttpStatus.OK);
      }
      
}
