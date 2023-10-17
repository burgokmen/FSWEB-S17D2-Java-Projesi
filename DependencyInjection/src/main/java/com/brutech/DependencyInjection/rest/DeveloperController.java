package com.brutech.DependencyInjection.rest;

import com.brutech.DependencyInjection.model.Developer;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DeveloperController {
    private Map<Integer, Developer> developers;



}
