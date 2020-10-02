package com.example.springBootAspect.controller;

import com.example.springBootAspect.model.Employee;
import com.example.springBootAspect.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> add(@RequestParam String id, @RequestParam String name){
        return ResponseEntity.ok()
                .body(repository.save(new Employee(id, name)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public List<Employee> getAll(){
        return repository.findAll();
    }

    @GetMapping("/get")
    public Employee get(@RequestParam String id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}
