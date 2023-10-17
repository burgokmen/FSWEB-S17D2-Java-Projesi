package com.brutech.DependencyInjection.model;

import com.brutech.DependencyInjection.enums.Experience;

public class JuniorDev extends Developer{
    public JuniorDev(int id, String name, double salary) {
        super(id, name, salary, Experience.JUNIOR);
    }
}
