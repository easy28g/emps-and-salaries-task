package kg.company.empsandsalariestask.services.impl;

import kg.company.empsandsalariestask.dao.EmployeesRepository;
import kg.company.empsandsalariestask.exceptions.MyExceptions;
import kg.company.empsandsalariestask.mappers.EmployeesMapper;
import kg.company.empsandsalariestask.models.Employees;
import kg.company.empsandsalariestask.models.dto.EmployeesDto;
import kg.company.empsandsalariestask.services.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeesServicesImpl implements EmployeesServices {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public EmployeesDto saveEmployees(EmployeesDto employeesDto) {
        if(employeesDto.getId() != employeesRepository.findEmplById(employeesDto.getId())) {
            Employees newEmployee = EmployeesMapper.INSTANCE.toEmployees(employeesDto);
            employeesRepository.save(newEmployee);
            return EmployeesMapper.INSTANCE.toEmployeesDto(newEmployee);
        } else {
            System.out.println("Сотрудник с таким Id уже существует!");
            return null;
        }
    }

    @Override
    public List<EmployeesDto> getAllEmployees() {
        List<Employees> employeesList = employeesRepository.findAll();
        return EmployeesMapper.INSTANCE.toEmployeesDtoList(employeesList);
    }

    @Override
    public EmployeesDto deactivateEmployee(Long id) {
        if(employeesRepository.existsById(id)){
            Employees employees = employeesRepository.findById(id).get();
            EmployeesDto employeesDto = EmployeesMapper.INSTANCE.toEmployeesDto(employees);
            employeesDto.setActive(false);
            Employees employeeToSave = employeesRepository.save(EmployeesMapper.INSTANCE.toEmployees(employeesDto));
            return EmployeesMapper.INSTANCE.toEmployeesDto(employeeToSave);
        }
        throw new MyExceptions("Сотрудник с таким ID не найден - deactivateEmployee");
    }
}


















