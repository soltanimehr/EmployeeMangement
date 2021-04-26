package com.mydomain.company.controller;

import com.mydomain.company.entity.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CompanyController {
    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id);
}
