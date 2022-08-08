package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModelProperty;

public enum Status {
      @ApiModelProperty(name = "ORDER : 주문완료 | CANCEL : 취소됨 | REFUND : 환불됨 | COMP : 배송완료 | DELIVERING : 배송중")
      ORDER, CANCEL, REFUND, COMP, DELIVERING
      
}