package com.mydomain.employee.controller.impl;

import com.mydomain.employee.VO.ResponseTemplateVO;
import com.mydomain.employee.controller.EmployeeController;
import com.mydomain.employee.dto.EmployeeRequestDto;
import com.mydomain.employee.entity.Employee;
import com.mydomain.employee.mapper.EmployeeMapper;
import com.mydomain.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author M.Soltani
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public ResponseEntity<Collection<EmployeeRequestDto>> findAll() {

        return new ResponseEntity<>(employeeMapper
                .mapListEntitytoDto(employeeService.findAll().stream().collect(Collectors.toList())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseTemplateVO> getEmployeeWithCompany(Long id) {
        ResponseTemplateVO responseTemplateVO = employeeService.getEmployeeWithCompany(id);
        return ResponseEntity.ok(responseTemplateVO);
    }

    @Override
    public ResponseEntity<EmployeeRequestDto> saveEmployee(EmployeeRequestDto employeeRequestDto) {
        log.info("Inside saveEmployee method of EmployeeController");

        Employee employee = employeeService.save(employeeMapper.employeeDtoToEmployee(employeeRequestDto));
        employeeRequestDto = employeeMapper.employeeToEmployeeDto(employee);
        return ResponseEntity.ok(employeeRequestDto);

    }

    @Override
    public ResponseEntity<EmployeeRequestDto> updateEmployee(Long id, EmployeeRequestDto employeeDetailsDto) {
        log.info("Inside updateEmployee method of EmployeeController");
        Employee employee = employeeService.update(id, employeeMapper.employeeDtoToEmployee(employeeDetailsDto));
        employeeDetailsDto = employeeMapper.employeeToEmployeeDto(employee);
        return ResponseEntity.ok(employeeDetailsDto);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return new ResponseEntity<>(employeeService.deleteById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BigDecimal> getAverageSalaryByCompanyId(Long companyId) {
        ResponseEntity<BigDecimal> doubleResponseEntity = new ResponseEntity<>(employeeService.getAverageSalaryByCompanyId(companyId), HttpStatus.OK);
        return doubleResponseEntity;
    }


}
