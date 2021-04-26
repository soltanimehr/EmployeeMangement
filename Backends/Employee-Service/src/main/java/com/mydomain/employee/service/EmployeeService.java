package com.mydomain.employee.service;

import com.mydomain.employee.VO.ResponseTemplateVO;
import com.mydomain.employee.dto.EmployeeRequestDto;

public interface EmployeeService extends IService<EmployeeRequestDto>{
    Double getAverageSalaryByCompanyId(Long companyId);

    ResponseTemplateVO getEmployeeWithCompany(Long employeeId);
}
