package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.UserDeliveryDto;
import com.dongnae.jjabpang.entity.Delivery;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.delivery.DeliveryRepository;
import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
 *packageName    : com.dongnae.jjabpang.service
 * fileName       : DeliveryService
 * author         : ipeac
 * date           : 2022-08-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-08        ipeac       최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryService {
      private final DeliveryRepository deliveryRepository;
      private final UserRepository userRepository;
      
      public Long addDelivery(UserDeliveryDto userDeliveryDto) throws Exception {
            User findUser = userRepository.findByUserNo(userDeliveryDto.getUserNo());
            
            if (findUser != null) {
                  //베송지 만들기
                  Delivery newDelivery = Delivery.createDelivery(findUser, userDeliveryDto.getAddress1(), userDeliveryDto.getAddress2(), userDeliveryDto.getDefault_delivery(), userDeliveryDto.getDeliveryName(), userDeliveryDto.getReceiver(), userDeliveryDto.getPhoneNum());
                  
                  deliveryRepository.save(newDelivery);
                  return newDelivery.getDeliveryNo();
            } else {
                  throw new IllegalStateException("없는 회원 입니다.");
            }
            
      }
}
