package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.jjim.JjimAddDto;
import com.dongnae.jjabpang.dto.jjim.JjimRemoveDto;
import com.dongnae.jjabpang.entity.Item;
import com.dongnae.jjabpang.entity.Jjim;
import com.dongnae.jjabpang.entity.JjimItem;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.ItemRepository;
import com.dongnae.jjabpang.repository.JjimItemRepository;
import com.dongnae.jjabpang.repository.JjimRepository;
import com.dongnae.jjabpang.repository.UserRepository;
import com.dongnae.jjabpang.response.Message;
import com.dongnae.jjabpang.response.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.dongnae.jjabpang.service
 * fileName       : JjimService
 * author         : jihye94
 * date           : 2022-08-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-13        jihye94       최초 생성
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JjimService {
      private final JjimItemRepository jjimItemRepository;
      private final JjimRepository jjimRepository;
      private final UserRepository userRepository;
      private final ItemRepository itemRepository;
      
      @Transactional
      public ResponseEntity addJjim(JjimAddDto jjimAddDto) {
            
            
            Optional<Jjim> findJjimNo = jjimRepository.findJjimByUser_UserNo(jjimAddDto.getUserNo());
            
            User findUser = userRepository.findById(jjimAddDto.getUserNo())
                                          .orElseThrow(() -> new IllegalStateException("해당 회원은 존재하지 않습니다"));
            
            if (findJjimNo.isEmpty()) {
                  Jjim jjim = Jjim.createJjim(findUser, null);
                  // 찜 테이블 완성 + 동시에 flush 로 DB 커밋됨.
                  jjimRepository.saveAndFlush(jjim);
            }
            
            Jjim findJjim = jjimRepository.findJjimByUser_UserNo(findUser.getUserNo())
                                          .orElseThrow(() -> new IllegalStateException("해당 찜리스트는 존재하지 않습니다"));
            
            
            Item item = itemRepository.findById(jjimAddDto.getItemNo())
                                      .orElseThrow(() -> new IllegalStateException("해당 아이템은 존재하지 않습니다"));
            
            //찜 번호와 아이템 중복 검증
            boolean chk_valid = jjimItemRepository.existsAllByItem_ItemNoAndJjim_JjimNo(jjimAddDto.getItemNo(), findJjim.getJjimNo());
            if (chk_valid) {
                  return new ResponseEntity("중복되는 찜 리스트가 존재합니다,", HttpStatus.BAD_REQUEST);
            }
            
            // 찜아이템에 찜과 아이템 설정 및 persist
            JjimItem jjimItem = new JjimItem();
            jjimItem.setJjim(findJjim);
            jjimItem.setItem(item);
            
            jjimItemRepository.save(jjimItem);
            
            
            // 찜아이템리스트로 반환
            List<JjimItem> allByJjim_jjimNo = jjimItemRepository.findAllByJjim_JjimNo(findJjim.getJjimNo());
            findJjim.setJjimItems(allByJjim_jjimNo);
            jjimRepository.save(findJjim);
            
            return new ResponseEntity("찜 저장완료", HttpStatus.OK);
      }
      
      @Transactional
      public ResponseEntity removeJjim(JjimRemoveDto jjimRemoveDto) {
            JjimItem findJjimItem = jjimItemRepository.findById(jjimRemoveDto.getJjimItemNo())
                                                      .orElseThrow(() -> new IllegalStateException("해당 상품이 존재하지 않습니다"));
            
            jjimItemRepository.delete(findJjimItem);
            
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            message.setMessage("해당 찜이 제거되었습니다");
            message.setStatus(StatusEnum.OK);
            message.setData(jjimRemoveDto.getJjimItemNo());
            
            return new ResponseEntity("해당 찜이 제거되었습니다.", headers, HttpStatus.OK);
      }
      
}
