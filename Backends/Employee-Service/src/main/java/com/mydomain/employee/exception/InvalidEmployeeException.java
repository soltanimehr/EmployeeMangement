package com.mydomain.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author M.Soltani
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeException extends RuntimeException {

    public InvalidEmployeeException() {
        super("Invalid employee !");
    }


}
