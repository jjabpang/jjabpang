package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : Category
 * author         : jihye94
 * date           : 2022-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-03        jihye94       최초 생성
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "category")
@Table(name = "category")
@ApiModel("카테고리")
public class Category extends BaseTimeEntity {
      @Id
      @Column(name = "category_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @ApiModelProperty(name = "카테고리 번호", required = true)
      private Long categoryNo;
      
      @Column(name = "category_name", length = 50)
      @ApiModelProperty(name = "카테고리 이름")
      private String categoryName;
      
      @Column(name = "parent_no")
      @ApiModelProperty(name = "부모 카테고리 번호")
      private Integer parentNo;
      
      @Column(name = "category_depth")
      @ApiModelProperty(name = "카테고리 깊이")
      private Integer categoryDepth;
      
      @OneToMany(fetch = LAZY, mappedBy = "category")
      @ApiModelProperty(name = "카테고리안의 상품")
      @ToString.Exclude
      List<Item> items = new ArrayList<>();
}
