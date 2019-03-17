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
            PrintWriter writer = new PrintWriter(output);

            switch (headers.getVerb()){
                case Get:
                    handleGet(headers,writer);
                    break;
                case Post:
                    break;
                case Put:
                    break;
                case Head:
                    break;
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleGet(Headers headers, PrintWriter writer) {
        byte[] bytes = new FileGetter().get(headers.getPath());
        writeCode(200,writer);
        //writer.println("Content-Type: text/html");
        writer.println("\r\n");

        for (byte b : bytes) {
            writer.print(b);
        }
        writer.flush();
    }

    private void writeCode(int code, PrintWriter writer) {
        switch (code){
            case 200:
                writer.println("HTTP/1.1 200 OK");
                break;
            case 304:
                writer.println("HTTP/1.1 304 Not Modified");
                break;
            case 400:
                writer.println("HTTP/1.1 400 Bad Request");
                break;
            case 404:
                writer.println("HTTP/1.1 404 Not Found");
                break;
            case 500:
                writer.println("HTTP/1.1 500 Server Error");
                break;

        }
    }
}
