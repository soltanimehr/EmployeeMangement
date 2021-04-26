package com.mydomain.employee.service;

import com.mydomain.employee.VO.ResponseTemplateVO;
import com.mydomain.employee.entity.Employee;
import java.math.BigDecimal;

/**
 * @author M.Soltani
 */
public interface EmployeeService extends IService<Employee> {

    BigDecimal getAverageSalaryByCompanyId(Long companyId);

    ResponseTemplateVO getEmployeeWithCompany(Long employeeId);
}
