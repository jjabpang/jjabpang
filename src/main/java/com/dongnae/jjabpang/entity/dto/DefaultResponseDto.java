package com.dongnae.jjabpang.entity.dto;

import lombok.Data;

/*
 *packageName    : com.dongnae.jjabpang.dto
 * fileName       : DefaultResponseDTO
 * author         : ipeac
 * date           : 2022-08-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-01        ipeac       최초 생성
 */
@Data
public class DefaultResponseDto {
      private String timeStamp;
      private int status;
      private String message;
      
}
