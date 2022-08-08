package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;

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
      @Column(name = "detail")
      private String detail;
      
      @Column(name = "image")
      private String image;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "item_no")
      @ToString.Exclude
      private Item item;
      
      /* 연관관계*/
      public void setItem(Item item) {
            this.item = item;
            item.getReviews()
                .add(this);
      }
      
      /*생성 메서드*/
      public static Review createReview(Item item) {
            Review review = new Review();
            review.setItem(item);
            
            return review;
      }
      
      /*비즈니스 로직*/
      
}
