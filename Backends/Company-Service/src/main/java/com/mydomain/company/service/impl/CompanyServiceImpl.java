package com.mydomain.company.service.impl;

import com.mydomain.company.entity.Company;
import com.mydomain.company.exception.ResourceNotFoundException;
import com.mydomain.company.repository.CompanyRepository;
import com.mydomain.company.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Collection findAll() {
        return null;
    }

    @Override
    public Company findById(Long id) {

        return companyRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Company with this Id:" + id + " does not exist!"));
    }

    @Override
    public Company save(Company company) {
        return null;
    }

    @Override
    public Company update(Long id, Company company) {
        return null;
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }


}
