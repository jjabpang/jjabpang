package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.ReviewDto;
import com.dongnae.jjabpang.entity.Item;
import com.dongnae.jjabpang.entity.Review;
import com.dongnae.jjabpang.repository.ReviewRepository;
import com.dongnae.jjabpang.repository.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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
      private final ItemRepository itemRepository;
      
      /**
       * 리뷰작성
       */
      public Long addReview(ReviewDto reviewDto) {
            Item findItem = itemRepository.findById(reviewDto.getItemNo())
                                          .orElseThrow(EntityNotFoundException::new);
            Review createdReview = Review.createReview(findItem);
            reviewRepository.save(createdReview);
            return createdReview.getReviewNo();
      }
      
      /**
       * 리뷰 삭제
       */
      public void removeReview(Long reviewNo) {
      
      }
}
