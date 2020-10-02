package com.example.springBootAspect.repository;

import com.example.springBootAspect.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
