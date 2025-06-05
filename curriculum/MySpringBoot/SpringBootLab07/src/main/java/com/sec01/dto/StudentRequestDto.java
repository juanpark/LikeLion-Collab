package com.sec01.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentRequestDto {
    private String name;
    private List<Long> courseIds;
}