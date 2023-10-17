package com.brutech.DependencyInjection.model;

import com.brutech.DependencyInjection.enums.Experience;

public class MidDev extends Developer {
    public MidDev(int id, String name, double salary) {
        super(id, name, salary, Experience.MID);
    }
}
