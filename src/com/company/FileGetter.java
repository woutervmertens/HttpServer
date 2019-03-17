package com.company;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileGetter {
    public FileGetter() {
    }

//    public List<String> get(String path) {
//        List<String> lines = null;
//        try {
//            lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lines;
//    }

    public byte[] get(String path) {
        byte[] byteArray=null;
        try {
           byteArray = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }
}
