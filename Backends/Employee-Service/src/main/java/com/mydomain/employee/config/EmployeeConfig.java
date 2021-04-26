package com.mydomain.employee.config;

import com.mydomain.employee.mapper.EmployeeMapperImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author M.Soltani
 */

@Configuration
public class EmployeeConfig {
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    };
   @Bean
   public ModelMapper modelMapper(){return  new ModelMapper();};
   @Bean
   public EmployeeMapperImpl employeeMapper(){return new EmployeeMapperImpl();}
}
