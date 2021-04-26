package com.mydomain.employee.service.impl;

import com.mydomain.employee.VO.ResponseTemplateVO;
import com.mydomain.employee.dto.CompanyDto;
import com.mydomain.employee.dto.EmployeeRequestDto;
import com.mydomain.employee.entity.Employee;
import com.mydomain.employee.exception.ResourceNotFoundException;
import com.mydomain.employee.repository.EmployeeRepository;
import com.mydomain.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author M.Soltani
 */

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final String COMPANY_API_URL = "http://localhost:9002/api/v1/companies/";
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BigDecimal getAverageSalaryByCompanyId(Long companyId) {
        return employeeRepository.getAverageSalaryByCompanyId(companyId);
    }

    @Override
    public ResponseTemplateVO getEmployeeWithCompany(Long employeeId) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();

        Employee employee = fetchEmployeeById(employeeId);
        CompanyDto companyDto = fetchCompanyDtoByRestApiCall(employee.getCompanyId());
        responseTemplateVO.setEmployeeRequestDto(modelMapper.map(employee, EmployeeRequestDto.class));
        responseTemplateVO.setCompanyDto(companyDto);
        return responseTemplateVO;
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employeeDetails) {
        Employee employee = fetchEmployeeById(id);
        employeeDetails.setId(id);
        return employeeRepository.save(employeeDetails);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            employeeRepository.deleteById(id);
            jsonObject.put("message", "Employee deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    private Employee fetchEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee with this Id:" + employeeId + " does not exist!"));

    }

    private CompanyDto fetchCompanyDtoByRestApiCall(Long companyId) {
        return restTemplate
                .getForObject(COMPANY_API_URL + companyId, CompanyDto.class);
    }


}