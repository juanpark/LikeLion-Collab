package com.lab02.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "이름은 필수입니다.")
	@Size(min = 2, max = 20, message="이름은 2~20자 이내")
	private String name;
	
	@NotBlank(message = "이메일은 필수입니다.")
	@Email(message = "올바른 이메일 형식이어야 합니다.")
	private String email;
}
