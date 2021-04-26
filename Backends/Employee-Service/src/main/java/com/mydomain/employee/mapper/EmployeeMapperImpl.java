package com.mydomain.employee.mapper;

import com.mydomain.employee.dto.EmployeeRequestDto;
import com.mydomain.employee.entity.Employee;
import java.util.ArrayList;
import java.util.List;
/**
 * @author M.Soltani
 */
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public List<EmployeeRequestDto> mapListEntitytoDto(List<Employee> employees) {
        if (employees == null) {
            return null;
        }

        List<EmployeeRequestDto> list = new ArrayList<EmployeeRequestDto>(employees.size());
        for (Employee employee : employees) {
            list.add(employeeToEmployeeDto(employee));
        }

        return list;
    }

    @Override
    public EmployeeRequestDto employeeToEmployeeDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeRequestDto employeeDTO = new EmployeeRequestDto();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurName(employee.getSurName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setCompanyId(employee.getCompanyId());
        employeeDTO.setSalary(employee.getSalary());

        return employeeDTO;
    }

    @Override
    public Employee employeeDtoToEmployee(EmployeeRequestDto employeeRequestDto) {
        if (employeeRequestDto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(employeeRequestDto.getId());
        employee.setName(employeeRequestDto.getName());
        employee.setSurName(employeeRequestDto.getSurName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setAddress(employeeRequestDto.getAddress());
        employee.setCompanyId(employeeRequestDto.getCompanyId());
        employee.setSalary(employeeRequestDto.getSalary());

        return employee;
    }
}
