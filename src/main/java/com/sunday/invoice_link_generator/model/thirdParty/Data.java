package com.sunday.invoice_link_generator.model.thirdParty;

public class Data {

    private String domain;
    private String alias;
    private String created_at;
    private String expires_at;
    private String tiny_url;
    private String url;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

    public String getTiny_url() {
        return tiny_url;
    }

    public void setTiny_url(String tiny_url) {
        this.tiny_url = tiny_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
