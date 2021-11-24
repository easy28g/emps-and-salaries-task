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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalariesServiceImpl implements SalariesService {

    // Need Logger

    @Autowired
    private SalariesRepository salariesRepository;

    @Override
    public SalariesDto saveSalaryAndEmpId(Long id, SalariesDto salariesDto) {

        Salaries salary = SalariesMapper.INSTANCE.toSalaries(salariesDto);

        return null;
    }
}
