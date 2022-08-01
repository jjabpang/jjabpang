package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
      
      @Autowired
      private SellerRepository sellerRepository;
      
      
}
