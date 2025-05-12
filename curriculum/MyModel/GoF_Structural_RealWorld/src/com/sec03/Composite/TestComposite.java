package com.sec03.Composite;
public class TestComposite {
    public static void main(String[] args) {
        FolderComposite root = new FolderComposite("root");
        root.add(new FileLeaf("file1.txt"));
        FolderComposite sub = new FolderComposite("sub");
        sub.add(new FileLeaf("file2.txt"));
        root.add(sub);
        root.show();
    }
}
