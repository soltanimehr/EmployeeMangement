package com.mydomain.employee.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
/**
 * @author M.Soltani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "SurName is mandatory")
    private String surName;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotNull
    private BigDecimal salary;
    @NotNull
    private Long companyId;
}
