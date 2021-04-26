package com.mydomain.employee.exception;

/**
 * @author M.Soltani
 */
public enum EmployeeServiceApplicationMessageTypeEnum {

    ERROR("ERROR"), WARN("WARN"), INFO("INFO");
    private String type;

    EmployeeServiceApplicationMessageTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
