package com.mydomain.employee.controller.impl;

import com.mydomain.employee.VO.ResponseTemplateVO;
import com.mydomain.employee.controller.EmployeeController;
import com.mydomain.employee.dto.EmployeeRequestDto;
import com.mydomain.employee.service.EmployeeService;
import com.mydomain.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

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


    @Override
    public ResponseEntity<Collection<EmployeeRequestDto>> findAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ResponseTemplateVO> getEmployeeWithCompany(Long id) {
        ResponseTemplateVO responseTemplateVO = employeeService.getEmployeeWithCompany(id);
        return ResponseEntity.ok(responseTemplateVO);
    }

    @Override
    public EmployeeRequestDto saveEmployee(EmployeeRequestDto employee) {
        log.info("Inside saveEmployee method of EmployeeController");
        if (employee == null) {
            log.info("employee==null Inside saveEmployee method of EmployeeController");
        }
        return employeeService.save(employee);
    }
    @Override
    public ResponseEntity<EmployeeRequestDto> updateEmployee(Long id, EmployeeRequestDto employeeDetails) {
        log.info("Inside updateEmployee method of EmployeeController");
        EmployeeRequestDto employeeRequestDto = employeeService.update(id, employeeDetails);
        return ResponseEntity.ok(employeeRequestDto);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return new ResponseEntity<>(employeeService.deleteById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Double> getAverageSalaryByCompanyId(Long companyId) {
        ResponseEntity<Double> doubleResponseEntity = new ResponseEntity<>(employeeService.getAverageSalaryByCompanyId(companyId), HttpStatus.OK);
        return doubleResponseEntity;
    }




}
