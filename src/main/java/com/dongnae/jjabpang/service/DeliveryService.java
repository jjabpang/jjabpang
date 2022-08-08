package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.repository.delivery.DeliveryRepository;
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
      
}
