package com.brutech.DependencyInjection.validation;

import com.brutech.DependencyInjection.model.Developer;

import java.util.Map;

public class DeveloperValidation {
    public static boolean isDevExist(Map<Integer, Developer> developers, int id){
        return developers.containsKey(id);
    }
}
