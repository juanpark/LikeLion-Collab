package com.test01;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public  class  GoodsVo{
	  private String code;
	  private String name;
	  private int price;
	  private String maker;
}