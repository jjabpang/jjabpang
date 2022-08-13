package com.dongnae.jjabpang.repository;

import com.dongnae.jjabpang.entity.Jjim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JjimRepository extends JpaRepository<Jjim, Long> {
}