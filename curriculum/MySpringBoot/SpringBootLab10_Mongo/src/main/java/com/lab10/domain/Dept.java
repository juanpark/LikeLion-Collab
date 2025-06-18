package com.lab10.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("dept")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    @Id
    private Integer deptno;
    private String dname;
    private String loc;

    // 지도 API 마커 표시를 위한 위도/경도 정보
    private Double latitude;   // 위도
    private Double longitude;  // 경도
}