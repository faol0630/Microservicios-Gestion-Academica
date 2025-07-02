package com.example.faol.models;

import java.util.List;

public class ResponseWrapper2 {

    private String message;
    private List<Student> list;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
