package kg.company.empsandsalariestask.models.dto;

import lombok.Data;

@Data
public class EmployeesDto {
    private Long id;
    private String firstName;
    private String secondName;
    private Boolean active;
}
