package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
      
      @Autowired
      private ItemRepository itemRepository;
      
      
}
