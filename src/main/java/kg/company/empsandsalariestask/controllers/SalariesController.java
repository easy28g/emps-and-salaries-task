package kg.company.empsandsalariestask.controllers;

import kg.company.empsandsalariestask.models.dto.SalariesDto;
import kg.company.empsandsalariestask.services.SalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/salaries")
public class SalariesController {

    @Autowired
    private SalariesService salariesService;

    @PostMapping("save-salary")
    public SalariesDto saveSalaries(@PathVariable Long id, @RequestBody SalariesDto salariesDto){
        return salariesService.saveSalaryAndEmpId(id, salariesDto);
    }
}
