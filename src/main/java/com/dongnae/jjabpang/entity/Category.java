package com.dongnae.jjabpang.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 카테고리
 */
@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {
      
      private static final long serialVersionUID = 1L;
      
      /**
       * 카테고리 번호
       */
      @Id
      @Column(name = "category_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer categoryNo;
      
      /**
       * 카테고리 이름
       */
      @Column(name = "category_name")
      private String categoryName;
      
      /**
       * 부모카테고리 번호
       */
      @Column(name = "parent_no")
      private Integer parentNo;
      
      /**
       * 카테고리 깊이
       */
      @Column(name = "category_depth")
      private Integer categoryDepth;
      
}
