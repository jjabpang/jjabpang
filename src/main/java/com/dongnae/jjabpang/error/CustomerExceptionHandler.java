package com.dongnae.jjabpang.error;
/*
 *packageName    : com.dongnae.jjabpang.error
 * fileName       : CustomerExceptionHandler
 * author         : ipeac
 * date           : 2022-08-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-01        ipeac       최초 생성
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class CustomerExceptionHandler {
      
      @ExceptionHandler
      public ResponseEntity<CustomerErrorResponse> processError(Exception e) {
            System.out.println("Exception");
            CustomerErrorResponse response = new CustomerErrorResponse();
            HttpStatus status = HttpStatus.NOT_FOUND;
            
            if (e instanceof MethodArgumentTypeMismatchException) {
                  status = HttpStatus.BAD_REQUEST;
                  response.setStatusCode(status.value());
                  response.setMessage("Only number is allowed");
            } else if (e instanceof DuplicatedUsernameException) {
                  status = HttpStatus.BAD_REQUEST;
                  response.setStatusCode(status.value());
                  response.setMessage(e.getMessage());
            } else {
                  status = HttpStatus.NOT_FOUND;
                  response.setStatusCode(status.value());
                  response.setMessage(e.getMessage());
            }
            
            response.setTimeStamp(System.currentTimeMillis());
            return new ResponseEntity<>(response, status);
      }
}
