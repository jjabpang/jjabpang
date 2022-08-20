package com.dongnae.jjabpang.controller;
/*
 *packageName    : com.dongnae.jjabpang.controller
 * fileName       : GlobalControllerAdvice
 * author         : ipeac
 * date           : 2022-08-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-21        ipeac       최초 생성
 */

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice  //RestAPI 컨트롤러용 advice
//@ViewResolverAdvice MVC 형식일때의 advice
public class GlobalControllerAdvice {
      
      @ExceptionHandler(value = Exception.class)
      public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
            //error 담을 리스트
            List<Error> errors = new ArrayList<>();
            
            //에러에서 BindingResult를 가져와
            BindingResult bindingResult = e.getBindingResult();
            //해당 BindingResult에서 발생한 에러를 모두 가져와 forEach을 통해 작업한다
            bindingResult.getAllErrors()
                         .forEach(error -> {
                  
                               //각각의 error 객체가 들어와 FieldError 타입으로 형변환 되고
                               FieldError field = (FieldError) error;
                               //해당 필드에서 이름, 에러 메세지 , 들어온 값을 뽑아낸다.
                               String fieldName = field.getField();
                               String message = field.getDefaultMessage();
                               String invalidValue = field.getRejectedValue()
                                                          .toString();
                  
                               // Error에 위에 뽑아놓은 에러정보를 담고
                               Error errorMessage = new Error();
                               errorMessage.setMessage(message);
                               errorMessage.setField(fieldName);
                               errorMessage.setInvalidValue(invalidValue);
                  
                               //에러리스트에 에러를 담았다.
                               errors.add(errorMessage);
                         });
            
            //실제 응답바디에 담길 errorResponse를 만들어 에러에 대한 기본정보를 담고
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("");
            errorResponse.setRequestUrl(request.getRequestURI());
            errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
            errorResponse.setResultCode("FAIL");
            //발생한 에러리스트를 담아준다.
            errorResponse.setErrorList(errors);
            
            //응답 바디에  errorResponse를 담아 리턴한다.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(errorResponse);
            
            
      }
      
      @Data
      public static class ErrorResponse {
            private String message;
            private String requestUrl;
            private String statusCode;
            private String resultCode;
            private List<Error> errorList;
            
      }
      
      @Data
      public static class Error {
            private String field;
            private String message;
            private String invalidValue;
            
      }
}