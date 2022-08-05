package com.dongnae.jjabpang.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : BaseTimeEntity
 * author         : jihye94
 * date           : 2022-07-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-31        jihye94       최초 생성
 */

/**
 * '@MappedSuperclass' : JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록 합니다.
 * '@EntityListeners(AuditingEntityListener.class)': BaseTimeEntiy 클래스에 Auditing 기능을 포함시킵니다.
 * '@CreatedDate': Entity가 생성되어 저장될 때 시간이 자동 저장됩니다.
 * '@LastModifiedDate': 조회한 Entity의 값을 변경할 때 시간이 자동 저장됩니다.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseTimeEntity {
      @CreatedDate
      @Column(name = "cdt", updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
      private String cdt;
      @LastModifiedDate
      @Column(name = "udt", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
      private String udt;
      
      @CreatedBy
      @Column(name = "crt_by")
      private String crtBy;
      
      @LastModifiedBy
      @Column(name = "upt_by")
      private String uptBy;
      
      @PrePersist
      public void onPrePersist() {
            this.cdt = LocalDateTime.now()
                                    .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            this.udt = this.cdt;
      }
      
      @PreUpdate
      public void onPreUpdate() {
            this.udt = LocalDateTime.now()
                                    .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
      }
}
