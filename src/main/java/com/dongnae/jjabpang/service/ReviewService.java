package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.ReviewDto;
import com.dongnae.jjabpang.entity.Review;
import com.dongnae.jjabpang.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 *packageName    : com.dongnae.jjabpang.service
 * fileName       : ReviewService
 * author         : ipeac
 * date           : 2022-08-09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-09        ipeac       최초 생성
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ReviewService {
      private final ReviewRepository reviewRepository;
      
      /**
       * 리뷰작성
       */
      public Review addReview(ReviewDto reviewDto) {
      
      }
}
