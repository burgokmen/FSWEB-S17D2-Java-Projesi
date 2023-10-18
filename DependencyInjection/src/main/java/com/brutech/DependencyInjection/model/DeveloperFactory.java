package com.brutech.DependencyInjection.model;

import com.brutech.DependencyInjection.tax.Taxable;

public class DeveloperFactory {
    public static Developer createDeveloper(Developer developer, Taxable taxable){
        Developer savedDeveloper = null;
        if(developer.getExperience().name().equalsIgnoreCase("JUNIOR")){
            savedDeveloper = new JuniorDev(developer.getId(), developer.getName(), developer.getSalary() - (developer.getSalary() * taxable.getSimpleTaxRate()));
        } else if (developer.getExperience().name().equalsIgnoreCase("mid")) {
            savedDeveloper = new MidDev(developer.getId(), developer.getName(), developer.getSalary() - (developer.getSalary() * taxable.getMiddleTaxRate()));

        } else if (developer.getExperience().name().equalsIgnoreCase("senior")) {
            savedDeveloper = new SeniorDev(developer.getId(), developer.getName(), developer.getSalary() - (developer.getSalary() * taxable.getUpperTaxRate()));

        }

        return savedDeveloper;
    }
}
