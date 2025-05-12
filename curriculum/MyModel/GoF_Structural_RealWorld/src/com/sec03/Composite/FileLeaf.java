package com.sec03.Composite;
public class FileLeaf implements Component {
    private final String name;
    public FileLeaf(String name) { this.name = name; }
    public void show() { System.out.println("File: " + name); }
}
