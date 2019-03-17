package com.company;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HTMLPageGetter {
    public HTMLPageGetter() {
    }
    public List<String> get() {
        return get("page.html");
    }

    public List<String> get(String path) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
