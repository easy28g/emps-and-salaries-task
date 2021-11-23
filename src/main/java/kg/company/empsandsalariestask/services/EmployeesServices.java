package kg.company.empsandsalariestask.services;

import kg.company.empsandsalariestask.models.dto.EmployeesDto;

import java.util.List;

public interface EmployeesServices {
    EmployeesDto saveEmployees(EmployeesDto employeesDto);
    List<EmployeesDto> getAllEmployees();
}
