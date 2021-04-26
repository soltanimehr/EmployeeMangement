package com.mydomain.company.config;

import com.mydomain.company.entity.Company;
import com.mydomain.company.repository.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfig {
    @Bean
    CommandLineRunner commandLineRunner(CompanyRepository companyRepository) {
        return args -> {
          Company company=  new Company(
                    1000L, "My Company NAME"
            );
            companyRepository.save(company);
        };

    }
}

