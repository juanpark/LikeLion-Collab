package com.sec06.Flyweight;
public class Font {
	
    private final String fontData;
    
    public Font(String fontData) { 
    	this.fontData = fontData; 
    }
    
    public void use() { 
    	System.out.println("Using font: " + fontData); 
    }
}
