package com.dongnae.jjabpang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.dongnae.jjabpang.config
 * fileName       : SecurityConfigTest
 * author         : jihye94
 * date           : 2022-08-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-14        jihye94       최초 생성
 */
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecurityConfigTest {
      
      @LocalServerPort
      private int port;
      
      @Autowired
      private TestRestTemplate restTemplate;
      
      //      @Test
      public void profile() throws Exception {
            String expected = "default";
            ResponseEntity<String> response = restTemplate.getForEntity("/profile", String.class);
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
            assertThat(response.getBody()).isEqualTo(expected);
      }
}