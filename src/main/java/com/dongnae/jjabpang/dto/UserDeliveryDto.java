package com.dongnae.jjabpang.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 *packageName    : com.dongnae.jjabpang.dto
 * fileName       : UserDeliveryDto
 * author         : ipeac
 * date           : 2022-08-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-08        ipeac       최초 생성
 */
@Setter
@Getter
@ApiModel(value = "배송지 DTO")
@AllArgsConstructor
public class UserDeliveryDto {
      @ApiModelProperty(name = "받는 사람")
      private String receiver;
      @ApiModelProperty(name = "기본 주소")
      private String address1;
      @ApiModelProperty(name = "상세주소")
      private String address2; // 상세 주소
      @ApiModelProperty(name = "휴대폰 번호")
      private String phoneNum;
      @ApiModelProperty(name = "기본 배송지 여부")
      private String default_delivery;
}
