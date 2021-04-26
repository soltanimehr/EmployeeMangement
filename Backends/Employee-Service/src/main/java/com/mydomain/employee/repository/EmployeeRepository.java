package com.mydomain.employee.repository;

import com.mydomain.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT avg(salary) from Employee where companyId = :companyId ")
    Double getAverageSalaryByCompanyId( @Param("companyId") Long companyId);
}
