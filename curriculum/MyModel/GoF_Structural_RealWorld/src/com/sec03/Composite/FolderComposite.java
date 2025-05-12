package com.sec03.Composite;
import java.util.*;
public class FolderComposite implements Component {
    
	private final String name;
    
	private final List<Component> children = new ArrayList<>();
    
	public FolderComposite(String name) { 
		this.name = name; 
	}
    
	public void add(Component c) { 
		children.add(c);	// 복합객체 추가 
	}
    
	public void show() {
        System.out.println("Folder: " + name);
        for (Component c : children) c.show();
    }
}
