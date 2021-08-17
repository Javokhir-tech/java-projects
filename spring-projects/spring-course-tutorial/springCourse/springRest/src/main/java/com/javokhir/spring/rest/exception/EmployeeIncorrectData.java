package com.javokhir.spring.rest.exception;

public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String message) {
        this.info = message;
    }
}
