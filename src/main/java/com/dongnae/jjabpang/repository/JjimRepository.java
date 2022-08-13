package com.dongnae.jjabpang.repository;

import com.dongnae.jjabpang.entity.Jjim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JjimRepository extends JpaRepository<Jjim, Long> {
      /**
       * 회원번호로 찜번호 찾기
       */
      Long findJjimNoByUser_UserNo(Long userNo);
      
      /**
       * 회원번호로 찜객체찾기
       */
      Optional<Jjim> findJjimByUser_UserNo(Long userNo);
}