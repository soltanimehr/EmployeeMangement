package com.mydomain.employee.VO;

import com.mydomain.employee.dto.CompanyDto;
import com.mydomain.employee.dto.EmployeeRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author M.Soltani
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private EmployeeRequestDto employeeRequestDto;
    private CompanyDto companyDto;
}
