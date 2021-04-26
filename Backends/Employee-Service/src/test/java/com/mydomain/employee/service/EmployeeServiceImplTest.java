package com.mydomain.employee.service;

import com.mydomain.employee.entity.Employee;
import com.mydomain.employee.repository.EmployeeRepository;
import com.mydomain.employee.service.impl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author M.Soltani
 */
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class EmployeeServiceImplTest {


    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void canFindById() {

        Employee employee = new Employee(
                1L, "Test", "TestSurName",
                "email@email.com", "Test Street", new BigDecimal(5000), 1000L
        );

        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Optional<Employee> employeeTest = employeeRepository.findById(1L);
        assertThat(employeeTest.isPresent()).isTrue();

    }

    @Test
    public void canSave() {

        Employee employee = new Employee(
                null, "Test", "TestSurName",
                "email@email.com", "Test Street", new BigDecimal(5000), 1000L
        );
        Employee employeeSaved = new Employee(
                1L, "Test", "TestSurName",
                "email@email.com", "Test Street", new BigDecimal(5000), 1000L
        );
        Mockito.when(employeeRepository.save(employee)).thenReturn(employeeSaved);
        Employee employeeTest = employeeRepository.save(employee);
        assertThat(employeeTest.getId()).isNotNull();

    }

    @Test
    public void canFindAll() {

        Employee employee = new Employee(
                null, "Test", "TestSurName",
                "email@email.com", "Test Street", new BigDecimal(5000), 1000L
        );
        List<Employee> listEmployee = new ArrayList<>();
        listEmployee.add(employee);
        Mockito.when(employeeRepository.findAll()).thenReturn(listEmployee);
        List<Employee> listTest = employeeRepository.findAll();
        assertThat(listTest, hasSize(1));

    }

}
