package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
      
      @Autowired
      private OrderRepository orderRepository;
      
      
}
