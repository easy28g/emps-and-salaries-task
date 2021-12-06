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
import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class SalariesServiceImpl implements SalariesService {

    @Autowired
    private SalariesRepository salariesRepository;
    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public SalariesDto saveSalaryAndEmpId(SalariesDto salariesDto) throws ExemptionMechanismException {
        try {
            if(salariesDto.getEmployees().getId() != salariesRepository.findSalaryByEmplId(salariesDto.getEmployees().getId())) {
                Salaries salary = SalariesMapper.INSTANCE.toSalaries(salariesDto);
                salariesRepository.save(salary);
                return SalariesMapper.INSTANCE.toSalariesDto(salary);
            } else {
                System.out.println("Не удалось сохранить сотрудника в списке зарплат");
                return null;
            }
        }catch (Exception e){
            throw new ExemptionMechanismException("SalariesServiceImpl: method - saveSalaryAndEmplId() catch(Exception e) \n " +
                    "Не удалось сохранить сотрудника в списке зарплат");
        }
    }

    @Override
    public SalariesDto changeSalaryColumn(SalariesDto salariesDto) {
        try {
            Salaries salaries = salariesRepository.findAllSeleryByEmplId(salariesDto.getEmployees().getId(), LocalDate.now());
            if(salaries!=null) {
                SalariesDto salariesDtoUpdated = SalariesMapper.INSTANCE.toSalariesDto(salaries);
                salariesDtoUpdated.setSalary(salariesDto.getSalary());
                salariesDtoUpdated.setStartDate(Date.valueOf(LocalDate.now()));
                salariesDtoUpdated.setEndDate(salariesDto.getEndDate());
                return SalariesMapper.INSTANCE.toSalariesDto(salariesRepository.save(SalariesMapper.INSTANCE.toSalaries(salariesDtoUpdated)));
            } else {
                System.out.println("Не удалсоь изменить зарплату для этого сотрудника");
                return null;
            }
        }catch (Exception e){
            throw new MyExceptions("SalariesServiceImpl - changeSalaryColumn method");
        }
    }
}
