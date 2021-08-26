package com.main.application.controllers.dto;

import java.io.Serializable;
import java.util.List;

public class ApiResponse <T> implements Serializable {
    
    private String message;
    private List<T> data;

    public ApiResponse() {
    }

    public ApiResponse( String message, List<T> data) {
        super();
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }
    public List<T> getData() {
        return data;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setData(List<T> data) {
        this.data = data;
    }

    
}
