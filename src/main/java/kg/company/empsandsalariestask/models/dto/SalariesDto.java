package kg.company.empsandsalariestask.models.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SalariesDto {
    private Long id;
    private BigDecimal salary;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EmployeesDto employees;
}
