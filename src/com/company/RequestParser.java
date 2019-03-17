package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class RequestParser {

    private BufferedReader reader;

    public RequestParser(BufferedReader reader) {
        this.reader = reader;
    }

    public Headers parseAndClose() throws IOException {
        //Create Response
        Headers response = new Headers();

        //Read and split first line
        String firstLine = reader.readLine();
        if (firstLine == null) {
            return null;
        }
        String[] splitFirstLine = firstLine.split(" ",3);

        //Set first line properties
        //ex. HTTP/1.1 200 OK
        response.setVerb(splitFirstLine[0]);
        response.setPath(splitFirstLine[1]);
        response.setHttpVersion(splitFirstLine[2]);

        //Set response Headers
        HashMap<String, String> headers = new HashMap<>();
        response.setHeaders(headers);



        boolean loop = true;
        //readBody headers
        while (loop){
            String line = reader.readLine();
            if(line.equals("")||line==null) loop = false;
            else{
                System.out.println(line);
                String[] parts = line.split(": ",2);
                headers.put(parts[0],parts[1]);
            }
        }

        return response;
    }
}
