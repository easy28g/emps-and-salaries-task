package kg.company.empsandsalariestask.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Salaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal salary;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employees employees;
}
