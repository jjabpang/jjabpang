package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
      
      @Autowired
      private CartRepository cartRepository;
      
}
