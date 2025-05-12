package com.sec06.Flyweight;
import java.util.*;
public class FontFactory {
    private static final Map<String, Font> fonts = new HashMap<>();

    public static Font getFont(String name) {
        return fonts.computeIfAbsent(name, Font::new);
    }
}
