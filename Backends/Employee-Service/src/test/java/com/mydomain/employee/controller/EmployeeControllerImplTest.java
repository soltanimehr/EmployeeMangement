package com.mydomain.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydomain.employee.EmployeeServiceApplication;
import com.mydomain.employee.dto.EmployeeRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = EmployeeServiceApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
@WebAppConfiguration
public class EmployeeControllerImplTest {
    private final String EMPLOYEE_SAVE_FINDALL_URL = "/api/v1/employees";
    private final String EMPLOYEE_UPDATE_DEL_GET_URL = "/api/v1/employees/{id}";
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    @Autowired
    private EmployeeController employeeController;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(employeeController).isNotNull();
    }

    @Test
    public void addEmployeeTest() throws Exception {
        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto(
                null, "Test", "TestSurName",
                "email@email.com", "Test Street", new BigDecimal(5000), 1000L
        );
        String jsonRequest = objectMapper.writeValueAsString(employeeRequestDto);
        log.info(jsonRequest);

        MvcResult mvcResult = mockMvc.perform(post(EMPLOYEE_SAVE_FINDALL_URL).contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk()).andReturn();
        mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void addEmployeeNullRequestTest() throws Exception {
        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto();
        String jsonRequest = objectMapper.writeValueAsString(employeeRequestDto);
        log.info(jsonRequest);

        MvcResult mvcResult = mockMvc.perform(post(EMPLOYEE_SAVE_FINDALL_URL).contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isBadRequest()).andReturn();
        mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void addEmployeeNullFieldRequestTest() throws Exception {
        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto(
                null, null, "TestSurName",
                "email@email.com", "Test Street", new BigDecimal(5000), 1000L
        );
        String jsonRequest = objectMapper.writeValueAsString(employeeRequestDto);
        log.info(jsonRequest);

        MvcResult mvcResult = mockMvc.perform(post(EMPLOYEE_SAVE_FINDALL_URL).contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isBadRequest()).andReturn();
        mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void findAllRequestTest() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get(EMPLOYEE_SAVE_FINDALL_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void updateEmployeeTest() throws Exception {
        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto(
                12L, "Test", "TestSurName",
                "email@email.com", "Test Street", new BigDecimal(5000), 1000L
        );

        String jsonRequest = objectMapper.writeValueAsString(employeeRequestDto);
        log.info(jsonRequest);

        MvcResult mvcResult = mockMvc.perform(put(EMPLOYEE_SAVE_FINDALL_URL + "/12").contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk()).andReturn();
        mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void getEmployeeWithCompanyRequestTest() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get(EMPLOYEE_SAVE_FINDALL_URL + "/12")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        mvcResult.getResponse().getContentAsString();
    }
}
