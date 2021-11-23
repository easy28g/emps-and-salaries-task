package kg.company.empsandsalariestask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MyExceptions extends RuntimeException{
    public MyExceptions(String message) {
        super(message);
    }
}
