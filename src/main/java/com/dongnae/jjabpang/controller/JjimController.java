package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.controller.UserController.Result;
import com.dongnae.jjabpang.dto.JjimAddDto;
import com.dongnae.jjabpang.dto.JjimListDto;
import com.dongnae.jjabpang.dto.JjimListResponseDto;
import com.dongnae.jjabpang.dto.JjimRemoveDto;
import com.dongnae.jjabpang.entity.Jjim;
import com.dongnae.jjabpang.entity.JjimItem;
import com.dongnae.jjabpang.repository.JjimItemRepository;
import com.dongnae.jjabpang.repository.JjimRepository;
import com.dongnae.jjabpang.response.Message;
import com.dongnae.jjabpang.response.StatusEnum;
import com.dongnae.jjabpang.service.JjimService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.dongnae.jjabpang.controller
 * fileName       : JjimController
 * author         : jihye94
 * date           : 2022-08-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-13        jihye94       최초 생성
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "찜")
@RequestMapping("/api/jjim")
public class JjimController {
      private final JjimService jjimService;
      private final JjimItemRepository jjimItemRepository;
      private final JjimRepository jjimRepository;
      
      @ApiOperation(value = "사용자별 찜리스트 조회")
      @GetMapping("/jjim")
      public Result findJjimByUser(@RequestBody JjimListDto jjimListDto) {
            
            
            Optional<Jjim> jjimNoList = jjimRepository.findJjimByUser_UserNo(jjimListDto.getUserNo());
            if (jjimNoList.isPresent()) {
                  Jjim jjim = jjimNoList.get();
                  List<JjimItem> result = jjimItemRepository.findAllByJjim_JjimNo(jjim.getJjimNo());
                  List<JjimListResponseDto> resultDtoList = new ArrayList<>();
                  
                  for (JjimItem jjimItem : result) {
                        JjimListResponseDto jjimListResponseDto = new JjimListResponseDto();
                        jjimListResponseDto.setDeliveryFee(jjimItem.getItem()
                                                                   .getDeliveryFee());
                        
                        jjimListResponseDto.setItemPrice(jjimItem.getItem()
                                                                 .getPrice());
                        jjimListResponseDto.setItemImg(jjimItem.getItem()
                                                               .getImage());
                        jjimListResponseDto.setItemTitle(jjimItem.getItem()
                                                                 .getTitle());
                        resultDtoList.add(jjimListResponseDto);
                  }
                  return new Result(resultDtoList);
                  
            }
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            
            message.setMessage("찜번호가 존재하지 않습니다");
            message.setStatus(StatusEnum.BAD_REQUEST);
            message.setData(null);
            
            return new Result(new ResponseEntity<Message>(message, headers, HttpStatus.BAD_REQUEST));
            
            
      }
      
      @ApiOperation(value = "찜 추가 기능")
      @PostMapping("/jjim")
      public ResponseEntity addJjim(@RequestBody JjimAddDto jjimAddDto) {
            
            return jjimService.addJjim(jjimAddDto);
      }
      
      @ApiOperation(value = "찜 삭제 기능")
      @PostMapping("/jjim/remove")
      public ResponseEntity removeJjim(@RequestBody JjimRemoveDto jjimRemoveDto) {
            return jjimService.removeJjim(jjimRemoveDto);
      }
      
}
