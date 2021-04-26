package com.mydomain.employee.service.impl;

import com.mydomain.employee.VO.ResponseTemplateVO;
import com.mydomain.employee.dto.CompanyDto;
import com.mydomain.employee.dto.EmployeeRequestDto;
import com.mydomain.employee.entity.Employee;
import com.mydomain.employee.exception.ResourceNotFoundException;
import com.mydomain.employee.repository.EmployeeRepository;
import com.mydomain.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.xml.validation.Validator;
import java.util.Collection;
import java.util.stream.Collectors;


@Slf4j
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
    public Double getAverageSalaryByCompanyId(Long companyId) {
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
    public Collection<EmployeeRequestDto> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeRequestDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeRequestDto save(@Valid EmployeeRequestDto employeeRequestDto) {
        Employee employee = modelMapper.map(employeeRequestDto, Employee.class);
        return modelMapper.map(employeeRepository.save(employee), EmployeeRequestDto.class);
    }

    @Override
    public EmployeeRequestDto update(Long id, @Valid EmployeeRequestDto employeeRequestDto) {

        Employee employee = fetchEmployeeById(id);
        employee = mapDtoToEntity(employee, employeeRequestDto);
        return modelMapper.map(employeeRepository.save(employee), EmployeeRequestDto.class);
    }

    private Employee mapDtoToEntity(Employee entity, EmployeeRequestDto employeeRequestDto) {
        Employee employee = modelMapper.map(employeeRequestDto, Employee.class);
        employee.setId(entity.getId());
        return employee;
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