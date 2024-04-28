package com.sunday.invoice_link_generator.config;

import org.springframework.beans.factory.annotation.Value;

public class URLConfig {
    @Value("${url.scheme}")
    private String scheme ;

    @Value("${url.host}")
    private String host;

    @Value("#{'${url.path}'.split('/')}")
    private String[] path;

    @Value("#{'${url.params}'.split(',')}")
    private String[] params;

    public String getScheme(){
        return this.scheme;
    }

    public String getHost(){
        return this.host;
    }

    public String[] getPath(){
        return this.path;
    }

    public  String[] getParams(){
        return this.params;
    }
}
