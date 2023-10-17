package com.brutech.DependencyInjection.model;

import com.brutech.DependencyInjection.enums.Experience;

public class SeniorDev extends Developer {
    public SeniorDev(int id, String name, double salary) {
        super(id, name, salary, Experience.SENIOR);
    }
}
