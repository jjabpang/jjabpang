package com.dongnae.jjabpang.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
@Entity(name = "review")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Review {
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

//      @ManyToOne(fetch = LAZY)
//      @JoinColumn()
}
