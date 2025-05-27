package com.lab02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
	private Long id;
	private String name;
}