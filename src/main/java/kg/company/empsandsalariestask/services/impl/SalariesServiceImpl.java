package kg.company.empsandsalariestask.services.impl;

import kg.company.empsandsalariestask.dao.EmployeesRepository;
import kg.company.empsandsalariestask.dao.SalariesRepository;
import kg.company.empsandsalariestask.exceptions.MyExceptions;
import kg.company.empsandsalariestask.mappers.SalariesMapper;
import kg.company.empsandsalariestask.models.Employees;
import kg.company.empsandsalariestask.models.Salaries;
import kg.company.empsandsalariestask.models.dto.SalariesDto;
import kg.company.empsandsalariestask.services.EmployeesServices;
import kg.company.empsandsalariestask.services.SalariesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalariesServiceImpl implements SalariesService {

    // Need Logger
//    private static final Logger LOGGER = LoggerFactory.getLogger(SalariesServiceImpl.class);

    @Autowired
    private SalariesRepository salariesRepository;

    @Override
    public SalariesDto saveSalaryAndEmpId(SalariesDto salariesDto) {
        try {
            Salaries salary = SalariesMapper.INSTANCE.toSalaries(salariesDto);
            if (salariesDto.getEmployees().getId() != salariesRepository.findSalaryByEmplId(salariesDto.getEmployees().getId())) {
                salariesRepository.save(salary);
                return SalariesMapper.INSTANCE.toSalariesDto(salary);
            } else {
                System.out.println("Сотрудник уже есть в списке зарплат - SalariesServiceImpl saveSalaryAndEmplId() sout");
                throw new MyExceptions("Сотрудник уже есть в списке зарплат - SalariesServiceImpl saveSalaryAndEmplId()");
            }
        }catch (Exception e){
            throw new MyExceptions("Сотрудник уже есть в списке зарплат - SalariesServiceImpl saveSalaryAndEmplId()");
        }
    }
}
