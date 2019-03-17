package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Main {

    public static void main(String argv[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8008);
        while (true){
            Socket socket = serverSocket.accept();
            if (socket == null) {
                continue;
            }
            Handler handler = new Handler(socket);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }
}
