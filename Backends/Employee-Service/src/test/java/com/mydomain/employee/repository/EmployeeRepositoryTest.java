package com.mydomain.employee.repository;

import com.mydomain.employee.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author M.Soltani
 */
@DataJpaTest
public class EmployeeRepositoryTest {
    private final Long companyId = 1000L;
    @Autowired
    private EmployeeRepository employeeRepository;

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    void employeeCreation() {
        Employee employee =
                new Employee(null, "Name",
                        "Surname", "email@email.com",
                        "Test Street", new BigDecimal(5000),
                        companyId);
        employee = employeeRepository.save(employee);
        Optional<Employee> employeeTest = employeeRepository.findById(employee.getId());
        assertThat(employeeTest.isPresent()).isTrue();
    }

    @Test
    void getAverageSalaryByCompanyId() {
        Employee employee =
                new Employee(null, "Name",
                        "Surname", "email@email.com",
                        "Test Street", new BigDecimal(5000),
                        companyId);
        employee = employeeRepository.save(employee);
        BigDecimal averageSalary = employeeRepository.getAverageSalaryByCompanyId(companyId);
        assertThat(averageSalary).isEqualByComparingTo(new BigDecimal(5000));
    }
}
