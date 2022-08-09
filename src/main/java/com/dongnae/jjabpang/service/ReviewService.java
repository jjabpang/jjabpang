package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.ReviewDto;
import com.dongnae.jjabpang.dto.ReviewDto.ReviewImageDto;
import com.dongnae.jjabpang.entity.Item;
import com.dongnae.jjabpang.entity.Review;
import com.dongnae.jjabpang.entity.ReviewImage;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.ReviewImageRepository;
import com.dongnae.jjabpang.repository.ReviewRepository;
import com.dongnae.jjabpang.repository.item.ItemRepository;
import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
      private final ReviewImageRepository reviewImageRepository;
      private final ItemRepository itemRepository;
      private final UserRepository userRepository;
      
      /**
       * 리뷰작성
       */
      @Transactional
      public Long addReview(ReviewDto reviewDto) {
            Item findItem = itemRepository.findById(reviewDto.getItemNo())
                                          .orElseThrow(EntityNotFoundException::new);
            
            User findUser = userRepository.findById(reviewDto.getUserNo())
                                          .orElseThrow(() -> new IllegalStateException("해당 회원이 존재하지 않습니다."));
            
            
            //이미지 제외 리뷰 작성함
            Review createdReview = Review.createReview(findUser, findItem, null);
            createdReview.setDetail(reviewDto.getDetail());
            createdReview.setDelYn("n");
            createdReview.setSummary(reviewDto.getSummary());
            
            reviewRepository.save(createdReview);
            return createdReview.getReviewNo();
      }
      
      /**
       * 이미지 업로드
       */
      @Transactional
      public Integer addImage(ReviewDto reviewDto, Long reviewNo) {
            Review findReview = reviewRepository.findById(reviewNo)
                                                .orElseThrow(() -> new IllegalStateException("해당 리뷰를 찾을 수 없습니다"));
            List<ReviewImageDto> reviewImages = reviewDto.getReviewImages();
            for (ReviewImageDto reviewImage : reviewImages) {
                  ReviewImage createdReviewImage = ReviewImage.createReviewImage(reviewImage.getImageUrl(), findReview);
                  reviewImageRepository.save(createdReviewImage);
                  findReview.addReviewImage(createdReviewImage);
            }
            
            return reviewImages.size();
            
      }
      
      /**
       * 리뷰 삭제
       */
      @Transactional
      public Long removeReview(Long reviewNo) {
            Review findReview = reviewRepository.findById(reviewNo)
                                                .orElseThrow(() -> new IllegalStateException("해당 리뷰가 없습니다."));
            
            findReview.setDelYn("y");
            
            return findReview.getReviewNo();
      }
}
