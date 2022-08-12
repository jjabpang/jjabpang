package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.ReviewDeleteDto;
import com.dongnae.jjabpang.dto.ReviewDto;
import com.dongnae.jjabpang.dto.ReviewDto.ReviewImageDto;
import com.dongnae.jjabpang.dto.ReviewListDto;
import com.dongnae.jjabpang.dto.condition.ReviewSearchCondition;
import com.dongnae.jjabpang.entity.Item;
import com.dongnae.jjabpang.entity.Review;
import com.dongnae.jjabpang.entity.ReviewImage;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.ReviewImageRepository;
import com.dongnae.jjabpang.repository.ReviewRepository;
import com.dongnae.jjabpang.repository.item.ItemRepository;
import com.dongnae.jjabpang.repository.querydsl.review.QReviewRepository;
import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
      private final QReviewRepository qReviewRepository;
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
       * 리뷰 목록 조회
       */
      public List<ReviewListDto> findReviewList(ReviewSearchCondition searchCondition, Pageable pageable) {
            
            
            PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.fromString(searchCondition.getOrderBy()), searchCondition.getSort()));
            
            List<ReviewListDto> reviewList = qReviewRepository.findReviewsDyPagingAndCondition(searchCondition, pageRequest)
                                                              .stream()
                                                              .collect(Collectors.toList());
            
            List<ReviewListDto> returnList = new ArrayList<>();
            
            for (ReviewListDto reviewListDto : reviewList) {
                  List<String> imageList = qReviewRepository.findImageUrlByReviewNo(String.valueOf(reviewListDto.getReviewNo()));
                  //이미지 설정
                  reviewListDto.setImageUrls(imageList);
                  returnList.add(reviewListDto);
            }
            return returnList;
      }
      
      /**
       * 리뷰 삭제
       */
      @Transactional
      public Long removeReview(ReviewDeleteDto reviewDeleteDto) throws IllegalAccessException {
            Review findReview = reviewRepository.findById(reviewDeleteDto.getReviewNo())
                                                .orElseThrow(() -> new IllegalStateException("해당 리뷰가 없습니다."));
            if (!Objects.equals(findReview.getUser()
                                          .getUserNo(), reviewDeleteDto.getUserNo())) {
                  throw new IllegalAccessException("해당 리뷰의 작성자가 아닙니다.");
            }
            
            findReview.setDelYn("y");
            
            return findReview.getReviewNo();
      }
      
}
