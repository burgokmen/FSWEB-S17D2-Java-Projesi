package com.brutech.DependencyInjection.rest;

import com.brutech.DependencyInjection.dto.DeveloperRecord;
import com.brutech.DependencyInjection.model.Developer;
import com.brutech.DependencyInjection.model.DeveloperFactory;
import com.brutech.DependencyInjection.tax.Taxable;
import com.brutech.DependencyInjection.validation.DeveloperValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    private Map<Integer, Developer> developers;
    private Taxable taxable;

    @PostConstruct
    public void init() {
        developers = new HashMap<>();
    }

    @Autowired
    public void setTaxable(Taxable taxable) {
        this.taxable = taxable;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public DeveloperRecord save(@RequestBody Developer developer) {
        if(DeveloperValidation.isDevExist(developers, developer.getId())){
            return new DeveloperRecord(null, "Developer already exist with given id " + developer.getId(), HttpStatus.BAD_REQUEST.value());
        }
        Developer savedDev = DeveloperFactory.createDeveloper(developer, taxable);
        if (savedDev != null) {
            developers.put(savedDev.getId(), savedDev);
        }
        return new DeveloperRecord(savedDev, "Developer saved successfully", HttpStatus.CREATED.value());

    }

    @GetMapping("/")
    public List<Developer> get(){
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public DeveloperRecord get(@PathVariable int id){
        if(!DeveloperValidation.isDevExist(developers, id)){
            return new DeveloperRecord(null, "Developer not found with given id " + id, HttpStatus.NOT_FOUND.value());
        }
        return new DeveloperRecord(developers.get(id), "Developer found successfully", HttpStatus.OK.value());
    }

    @PutMapping("/{id}")
    public DeveloperRecord update(@PathVariable int id, @RequestBody Developer developer){
        if(!DeveloperValidation.isDevExist(developers, id)){
            return new DeveloperRecord(null, "Developer not found with given id " + id, HttpStatus.NOT_FOUND.value());
        }
        developer.setId(id);
        Developer updatedDev = DeveloperFactory.createDeveloper(developer, taxable);
        developers.put(id, updatedDev);
        return new DeveloperRecord(developers.get(id), "Developer with given id: " + id + " is updated", 200);
    }

    @DeleteMapping("/{id}")
    public DeveloperRecord remove(@PathVariable int id){
        if(!DeveloperValidation.isDevExist(developers, id)){
            return new DeveloperRecord(null, "Developer not found with given id " + id, HttpStatus.NOT_FOUND.value());
        }
        Developer removedDev = developers.remove(id);
        return new DeveloperRecord(removedDev, "Developer with given id: " + id + " is removed", 200);
    }

}
