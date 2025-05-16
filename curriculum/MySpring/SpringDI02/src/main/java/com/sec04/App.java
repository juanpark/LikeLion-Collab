package com.sec04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sec01.MyAddress;

@Configuration
public class App {
	
	@Bean
	public MyAddress m01() {
		return new MyAddress("홍길","1111","1111");
	}
	
	@Bean
	public MyAddress m02() {
		return new MyAddress("정길동","1111","1111");
	}
	
	@Bean
	public MyCollection myCollection() {
		
		MyCollection m = new MyCollection();	
		m.setItems(Arrays.asList("AA","BB","CC"));
		m.setMyarray(new String[] {"AAS","BBS","CCS"});
		m.setMyset(Set.of("AA","BB","CC","DD"));
		m.setMymap(Map.of("A","a","B","bb","C","c"));
		
		Map<String,MyAddress> U_map = new HashMap<>();
		U_map.put("a", m01());
		U_map.put("b", m02());
		m.setMyAddr(U_map);
		
		return m;
	}
}
