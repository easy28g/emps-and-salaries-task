package kg.company.empsandsalariestask.services.impl;

import kg.company.empsandsalariestask.dao.EmployeesRepository;
import kg.company.empsandsalariestask.mappers.EmployeesMapper;
import kg.company.empsandsalariestask.models.Employees;
import kg.company.empsandsalariestask.models.dto.EmployeesDto;
import kg.company.empsandsalariestask.services.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesServicesImpl implements EmployeesServices {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public EmployeesDto saveEmployees(EmployeesDto employeesDto) {
        Employees newEmployee = EmployeesMapper.INSTANCE.toEmployees(employeesDto);
        employeesRepository.save(newEmployee);
        return EmployeesMapper.INSTANCE.toEmployeesDto(newEmployee);
    }
}


















