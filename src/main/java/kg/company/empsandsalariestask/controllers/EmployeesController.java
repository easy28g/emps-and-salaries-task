package kg.company.empsandsalariestask.controllers;

import kg.company.empsandsalariestask.models.dto.EmployeesDto;
import kg.company.empsandsalariestask.services.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeesController {

    @Autowired
    private EmployeesServices employeesServices;

    @PostMapping("/save")
    public EmployeesDto send(@RequestBody EmployeesDto employeesDto){
        return employeesServices.saveEmployees(employeesDto);
    }
}
