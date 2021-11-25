package kg.company.empsandsalariestask.models.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SalariesDto {
    private Long id;
    private BigDecimal salary;
    private Date startDate;
    private Date endDate;
    private EmployeesDto employees;
}
