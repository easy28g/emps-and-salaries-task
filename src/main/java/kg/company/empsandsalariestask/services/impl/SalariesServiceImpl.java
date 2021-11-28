package kg.company.empsandsalariestask.services.impl;

import kg.company.empsandsalariestask.dao.EmployeesRepository;
import kg.company.empsandsalariestask.dao.SalariesRepository;
import kg.company.empsandsalariestask.exceptions.EmployeeExistsExceptions;
import kg.company.empsandsalariestask.exceptions.MyExceptions;
import kg.company.empsandsalariestask.mappers.SalariesMapper;
import kg.company.empsandsalariestask.models.Salaries;
import kg.company.empsandsalariestask.models.dto.SalariesDto;
import kg.company.empsandsalariestask.services.SalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.ExemptionMechanismException;

@Service
public class SalariesServiceImpl implements SalariesService {

    @Autowired
    private SalariesRepository salariesRepository;
    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public SalariesDto saveSalaryAndEmpId(SalariesDto salariesDto) throws ExemptionMechanismException {
        try {
            Salaries salary = SalariesMapper.INSTANCE.toSalaries(salariesDto);
            if ((salariesDto.getEmployees().getId() != salariesRepository.findSalaryByEmplId(salariesDto.getEmployees().getId()))
                && (salariesDto.getEmployees().getId() == employeesRepository.findEmplById(salariesDto.getEmployees().getId()))){
                salariesRepository.save(salary);
                return SalariesMapper.INSTANCE.toSalariesDto(salary);
            } else {
                System.out.println("Не удалось добавить сотрудника в список зарплат!");
                return null;
            }
        }catch (Exception e){
            throw new ExemptionMechanismException("SalariesServiceImpl: method - saveSalaryAndEmplId() catch(Exception e)");
        }
    }
}
