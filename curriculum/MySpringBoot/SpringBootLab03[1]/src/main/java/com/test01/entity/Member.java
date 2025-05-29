package com.test01.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor @AllArgsConstructor
public @Data class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //DB위임
    private Long id;
    
    @Column(nullable = false, unique = true) //데이터 유일값
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String role = "ROLE_USER";
    private LocalDateTime createdAt = LocalDateTime.now(); //최초 생성 시점
}
