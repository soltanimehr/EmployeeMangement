package com.mydomain.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author M.Soltani
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
}
