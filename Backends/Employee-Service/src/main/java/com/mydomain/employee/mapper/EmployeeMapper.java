package com.mydomain.employee.mapper;

import com.mydomain.employee.dto.EmployeeRequestDto;
import com.mydomain.employee.entity.Employee;
import java.util.List;


public interface EmployeeMapper {
   List<EmployeeRequestDto> mapListEntitytoDto(List<Employee> employees);
    EmployeeRequestDto employeeToEmployeeDto(Employee employee);
    Employee employeeDtoToEmployee(EmployeeRequestDto employeeRequestDto);
}

