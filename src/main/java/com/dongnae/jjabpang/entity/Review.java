package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

/*
 *packageName    : com.dongnae.jjabpang.entity
 * fileName       : Review
 * author         : ipeac
 * date           : 2022-08-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-08        ipeac       최초 생성
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "review")
@Table(name = "review")
@ApiModel("리뷰엔티티")
public class Review extends BaseTimeEntity {
      /**
       * 리뷰 번호
       */
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "review_no", nullable = false)
      private Long reviewNo;
      /**
       * 상세리뷰
       */
      @Column(name = "detail", columnDefinition = "NVARCHAR(3000)")
      private String detail;
      
      /**
       * 한줄 요약
       */
      @Column(name = "summary", columnDefinition = "NVARCHAR(50)")
      private String summary;
      
      /**
       * 삭제여부
       */
      @Column(name = "del_yn", columnDefinition = "VARCHAR(10)")
      private String delYn;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "item_no")
      @ToString.Exclude
      private Item item;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "user_no")
      @ToString.Exclude
      private User user;
      
      @OneToMany(fetch = LAZY, mappedBy = "review")
      private List<ReviewImage> reviewImages = new ArrayList<>();
      
      /* 연관관계*/
      public void setItem(Item item) {
            this.item = item;
            item.getReviews()
                .add(this);
      }
      
      public void addReviewImage(ReviewImage reviewImage) {
            reviewImages.add(reviewImage);
            reviewImage.setReview(this);
      }
      
      /*생성 메서드*/
      public static Review createReview(User user, Item item, List<ReviewImage> reviewImages) {
            
            Review review = new Review();
            review.setItem(item);
            review.setUser(user);
            
            if (reviewImages != null) {
                  for (ReviewImage reviewImage : reviewImages) {
                        review.addReviewImage(reviewImage);
                  }
            }
            
            return review;
      }
      
      /*비즈니스 로직*/
      
}
