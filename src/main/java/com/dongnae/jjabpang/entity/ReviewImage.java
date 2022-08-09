package com.dongnae.jjabpang.entity;

import io.swagger.annotations.Api;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "review_image")
@Api(tags = "상품명 이미지 엔티티")
public class ReviewImage extends BaseTimeEntity {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "review_image_no", nullable = false)
      private Long reviewImageNo;
      
      @Column(name = "image_url", columnDefinition = "VARCHAR(500)")
      private String imageUrl;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "review_no")
      private Review review;
      
      /*연관관계 생성 메서드*/
      public static ReviewImage createReviewImage(Review review) {
            ReviewImage reviewImage = new ReviewImage();
            reviewImage.setReview(review);
            return reviewImage;
      }
      /**/
      
      
}