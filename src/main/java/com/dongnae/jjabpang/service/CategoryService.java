package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
      
      @Autowired
      private CategoryRepository categoryRepository;
}
