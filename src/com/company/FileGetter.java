package com.company;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileGetter {
    public FileGetter() {
    }

    public List<String> getLines(String path) {
        List<String> lines = new ArrayList<>();
        path = "."+path;
        try {
            lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public byte[] getBytes(String path) {
        byte[] byteArray=null;
        path = "."+path;
        path="afbeelding.png";
        try {
           byteArray = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }
}
