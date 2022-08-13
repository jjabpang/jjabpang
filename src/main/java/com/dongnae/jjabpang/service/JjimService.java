package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.repository.JjimItemRepository;
import com.dongnae.jjabpang.repository.JjimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
public class JjimService {
      private final JjimItemRepository jjimItemRepository;
      private final JjimRepository jjimRepository;
      
      
}
