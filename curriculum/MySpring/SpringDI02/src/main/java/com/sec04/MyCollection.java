package com.sec04;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.sec01.MyAddress;

public class MyCollection {
	private List<String> items;
	private String[] myarray;
	private Set<String> myset;
	private Map<String,String> mymap;
	private Map<String, MyAddress> myaddr;
	
	public void setMyAddr(Map<String,MyAddress> item) {
		this.myaddr = item;
	}
	public void printMyaddr() {
		for(Map.Entry<String, MyAddress> entry : myaddr.entrySet()) {
			System.out.println(entry.getKey()+" : " + entry.getValue());
		}
	}
	
	// 소문자여야 prefix로 set Capital letter
	public void setItems(List<String> items) {
		this.items = items;
	}
	
	public void setMyarray(String[] myarray) {
		this.myarray = myarray;
	}
	
	public void setMymap(Map<String, String> mymap) {
		this.mymap = mymap;
	}

	public void setMyset(Set<String> items) {
		this.myset = items;
	}

	public void printItems() {
		System.out.println("Item in list");
		for(String item : items) {
			System.out.println(" - " + item);
		}
	}
	
	public void printArray() {
		System.out.println("Item in array");
		for(String item : myarray) {
			System.out.println(" - " + item);
		}
	}
	
	public void printSet() {
		System.out.println("Item in set");
		for(String item : myset) {
			System.out.println(" - " + item);
		}
	}
	
	public void printMap() {
		for(Map.Entry<String, String> entry : mymap.entrySet()) {
			System.out.println("-KEY : "+ entry.getKey()+"  -Value : " + entry.getValue());
		}
		
	}
}


























