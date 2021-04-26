package com.mydomain.employee.controller;

import com.mydomain.employee.VO.ResponseTemplateVO;
import com.mydomain.employee.dto.EmployeeRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author M.Soltani
 */
public interface EmployeeController {
    @GetMapping("/employees")
    @ResponseBody
    ResponseEntity<Collection<EmployeeRequestDto>> findAll();

    @PostMapping("/employees")
    public ResponseEntity<EmployeeRequestDto> saveEmployee(@RequestBody @Valid EmployeeRequestDto employeeRequestDto);

    @GetMapping("/employees/company/{id}/salary/avg/")
    @ResponseBody
    public ResponseEntity<BigDecimal> getAverageSalaryByCompanyId(@PathVariable("id") Long companyId);

    @GetMapping("/employees/{id}")
    public ResponseEntity<ResponseTemplateVO> getEmployeeWithCompany(@PathVariable Long id);

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeRequestDto> updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeRequestDto employeeDetails);

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id);
}
