package com.dongnae.jjabpang.repository.delivery;
/*
 *packageName    : com.dongnae.jjabpang.repository.delivery
 * fileName       : DeliveryRepository
 * author         : ipeac
 * date           : 2022-08-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-08        ipeac       최초 생성
 */

import com.dongnae.jjabpang.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
