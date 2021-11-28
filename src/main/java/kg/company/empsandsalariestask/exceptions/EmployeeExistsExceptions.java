package kg.company.empsandsalariestask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CREATED)
public class EmployeeExistsExceptions extends RuntimeException{
    public EmployeeExistsExceptions(String message){
        super(message);
    }
}
