package com.brutech.DependencyInjection.dto;

import com.brutech.DependencyInjection.model.Developer;

public class DeveloperRecord {
    private Developer developer;
    private String message;
    private int status;

    public DeveloperRecord(Developer developer, String message, int status) {
        this.developer = developer;
        this.message = message;
        this.status = status;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
