package com.company;

import java.util.Map;

public class Headers {
    private String path;
    private Verb verb;
    private String httpVersion;
    private Map<String,String> headers;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Verb getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
             if(verb.equalsIgnoreCase("GET"))  this.verb = Verb.Get;
        else if(verb.equalsIgnoreCase("POST")) this.verb = Verb.Post;
        else if(verb.equalsIgnoreCase("HEAD")) this.verb = Verb.Head;
        else if(verb.equalsIgnoreCase("PUT"))  this.verb = Verb.Put;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public Headers() {
    }


    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }



}
