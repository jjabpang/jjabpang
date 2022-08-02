package com.dongnae.jjabpang.response;

/*
 *packageName    : com.dongnae.jjabpang.response
 * fileName       : StatusEnum
 * author         : ipeac
 * date           : 2022-08-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-02        ipeac       최초 생성
 */
public enum StatusEnum {
      
      OK(200, "OK"),
      BAD_REQUEST(400, "BAD_REQUEST"),
      NOT_FOUND(404, "NOT_FOUND"),
      INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR");
      
      int statusCode;
      String code;
      
      StatusEnum(int statusCode, String code) {
            this.statusCode = statusCode;
            this.code = code;
      }
}
