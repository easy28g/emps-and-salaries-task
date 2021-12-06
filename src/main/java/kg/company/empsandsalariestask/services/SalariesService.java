package kg.company.empsandsalariestask.services;

import kg.company.empsandsalariestask.models.dto.SalariesDto;

import javax.crypto.ExemptionMechanismException;

public interface SalariesService {
    SalariesDto saveSalaryAndEmpId(SalariesDto salariesDto) throws ExemptionMechanismException;
    SalariesDto changeSalaryColumn(SalariesDto salariesDto);
}
