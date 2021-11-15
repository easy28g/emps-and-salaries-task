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
        Employees newEmployeeDto = new Employees();
        newEmployeeDto.setId(employeesDto.getId());
        newEmployeeDto.setFirstName(employeesDto.getFirstName());
        newEmployeeDto.setSecondName(employeesDto.getSecondName());
        newEmployeeDto.setActive(employeesDto.getActive());
        return EmployeesMapper.INSTANCE.toEmployeesDto(employeesRepository.save(newEmployeeDto));
    }
}


















