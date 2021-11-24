package kg.company.empsandsalariestask.services;

import kg.company.empsandsalariestask.models.dto.SalariesDto;

public interface SalariesService {
    SalariesDto saveSalaryAndEmpId(Long id, SalariesDto salariesDto);
}
