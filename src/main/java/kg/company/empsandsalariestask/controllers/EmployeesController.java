package kg.company.empsandsalariestask.controllers;

import kg.company.empsandsalariestask.models.dto.EmployeesDto;
import kg.company.empsandsalariestask.services.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeesController {

    @Autowired
    private EmployeesServices employeesServices;

    @PostMapping("/save")
    public EmployeesDto send(@RequestBody EmployeesDto employeesDto){
        return employeesServices.saveEmployees(employeesDto);
    }

    @GetMapping("/get-all-employees")
    public List<EmployeesDto> employeesDtoList(){
        return employeesServices.getAllEmployees();
    }

    @DeleteMapping("/deactivate-employee/{id}")
    public EmployeesDto deactivateEmployeeById(@PathVariable Long id){
        return employeesServices.deactivateEmployee(id);
    }
}
