package com.company;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Handler implements Runnable {
    Socket socket;
    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

             Headers headers = new RequestParser(reader).parseAndClose();



            OutputStream output = socket.getOutputStream();

            List<String> htmlLines = new HTMLPageGetter().get();

            PrintWriter writer = new PrintWriter(output);
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type: text/html");
            writer.println("\r\n");

            for (String line : htmlLines) {
                writer.print(line);
            }
            writer.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
