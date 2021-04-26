package com.mydomain.company.controller.impl;

import com.mydomain.company.controller.CompanyController;
import com.mydomain.company.entity.Company;
import com.mydomain.company.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class CompanyControllerImpl implements CompanyController {
    @Autowired
    private CompanyService companyService;

    @Override
    public ResponseEntity<Company> findById(Long id) {
        Company company = companyService.findById(id);
        return ResponseEntity.ok(company);
    }

}
