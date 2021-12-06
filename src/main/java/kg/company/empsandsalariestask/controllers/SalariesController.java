package kg.company.empsandsalariestask.controllers;

import kg.company.empsandsalariestask.models.dto.SalariesDto;
import kg.company.empsandsalariestask.services.SalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.ExemptionMechanismException;

@RestController
@RequestMapping("api/v1/salaries")
public class SalariesController {

    @Autowired
    private SalariesService salariesService;

    @PostMapping("/save-salary")
    public SalariesDto saveSalaries(@RequestBody SalariesDto salariesDto) throws ExemptionMechanismException {
        return salariesService.saveSalaryAndEmpId(salariesDto);
    }

    @PutMapping("/change")
    public SalariesDto changeSalary(@RequestBody SalariesDto salariesDto){
        return salariesService.changeSalaryColumn(salariesDto);
    }
}


















