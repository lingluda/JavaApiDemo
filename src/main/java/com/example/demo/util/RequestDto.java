package com.example.demo.util;

public class RequestDto<T> {
    private T data;
    private String platform;
    private String version;

    public RequestDto() {
    }

    public String toString() {
        return "RequestDto{data=" + this.data + ", platform='" + this.platform + '\'' + ", version='" + this.version + '\'' + '}';
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
